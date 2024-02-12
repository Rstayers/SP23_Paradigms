const fs = require('fs');


class Defect{
	constructor(bug_id, component, status, resolution, summary, blocks, depends, fixed_by_username, fixed_by_real_name){
		this.bug_id = bug_id;
		this.component = component;
		this.status = status;
		this.resolution = resolution;
		this.summary = summary;
		this.blocks = blocks;
		this.depends = depends;
		this.fixed_by_username = fixed_by_username;
		this.fixed_by_real_name = fixed_by_real_name;
	}
}


function loadObjects(){

	//list of Defect objects
   	const defects = [];
	const defectMap = {};
	
	//Load and parse defects.csv
	const defectData = fs.readFileSync('defects.csv', 'utf-8').split('\n').slice(1);
	defectData.forEach(row => {
		const [bug_id, component, status, resolution, summary, , , , , , , , , fixed_by_username] = row.split(',');
		const defect = new Defect(parseInt(bug_id), component, status, resolution, summary, [], [],  fixed_by_username, '');
		defectMap[bug_id] = defect;
	});

	// Load and parse defect_blocks.csv
    const blocksData = fs.readFileSync('defect_blocks.csv', 'utf8').split('\n').slice(1);
    blocksData.forEach(row => {
        const [from_defect_id, to_defect_id] = row.split(',');
        if (defectMap[from_defect_id]) {
            defectMap[from_defect_id].blocks.push(parseInt(to_defect_id));
        }
    });
	
	// Load developers.csv to get real names
    const developerData = fs.readFileSync('developers.csv', 'utf8').split('\n').slice(1);
    const developerMap = {};
    developerData.forEach(row => {
        const [real_name, username] = row.split(',');
        developerMap[username] = real_name;
    });

    // Populate real names for each defect
    Object.values(defectMap).forEach(defect => {
        defect.fixed_by_real_name = developerMap[defect.fixed_by_username] || null; // Set real name based on username from developers.csv
        defects.push(defect);
    });


    return defects;
   
}


function query1(defects){
	//simple filter
    const solved = defects.filter(defect => defect.status === 'RESOLVED' && defect.resolution === 'FIXED').length;
    return solved;
}

function query2(defects){
	//filter undefined fields then filter by includes and force to lower case
	const contains = defects.filter(defect => defect.summary !== undefined).filter(defect => defect.summary.toLowerCase().includes('buildbot')).length;
    return contains;
}

function query3(defects){

	// simple filter and percent calculation
    const percent = defects.filter(defect => defect.status !== 'RESOLVED').length;
	//return as a rounded number
    return Number(((percent / defects.length) * 100).toFixed(2));    
}

function query4(defects){

	// get count for each component
   	const components = defects.reduce((counts, defect) => {
		counts[defect.component] = (counts[defect.component] || 0) + 1;
		return counts
	}, {});
    
	//sort map by key and return top
	const most = Object.keys(components).sort((a, b) => components[b] - components[a]);
	return most[0];
}

function query5(defects){
	
	//get counts like last query
    const devs = defects.filter(defect => defect.component === 'Documentation' && defect.status === 'RESOLVED' && defect.resolution === 'FIXED').reduce((counts, defect) => {
		counts[defect.fixed_by_username] = (counts[defect.fixed_by_username] || 0) + 1;
		return counts
	}, {});
	
	//get list of top devs and return top 2
	const topDevelopers = Object.keys(devs).sort((a, b) => devs[b] - devs[a]).slice(0, 2);

    return topDevelopers;
}


function query6(defects){
	// find circular dependencies with graph traversals
	
    const visited = new Set();
	function dfs(defect, path)
	{
		if(visited.has(defect.bug_id))
		{
			return false;
		}
		visited.add(defect.bug_id);
		path.push(defect.bug_id);

		//loop through each bug that is blocking and recursively traverse each branch
		for (const block in defect.blocks)
		{
			const next = defect.find(d => d.bug_id === block);

			// if we come across a bug we've already seen, it's a circular dependency
			if(path.includes(block))
			{
				return true;
			}
			if(dfs(next, [...path]))
			{
				return true;
			}
		}
		return false
	}
	// call the dfs function on each defect
	for (const defect in defects)
	{
		if(!visited.has(defect.bug_id) && dfs(defect, []))
		{
			return true;
		}
	}
    return false;    
}


let defects = loadObjects();
query1(defects);
query2(defects);
query3(defects);
query4(defects);
query5(defects);
query6(defects);
