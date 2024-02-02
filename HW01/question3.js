
function getToPosition(position)
{
	
	var i = 0;
	var j = 0;
	var total = 1;
	var rowStop = 0;
	var colStop = 0;
	out: while (total < position)
	{
		colStop++;
		rowStop++;
		i++;
		total++;
		if (total === position){ break out; };
		while (i > 0 && j < colStop)
		{
			i--;
			j++;
			total++;
			if (total === position){ break out;}
		}
		colStop++;
		rowStop++;
		j++;
		total++;
		if (total === position){ break out; };
		while (i < rowStop && j > 0)
		{
			i++;
			j--;
			total++;
			if (total === position){ break out;}	
		}

	}
	return `${(i+1)*2}/${(j+1)*2}`;
}

function compute(termPositions) 
{
    /* your solution goes here */
	const result = [];
	for(let i = 0; i < termPositions.length; i++)
	{
		const position = termPositions[i];
		if (position < 1){
			result.push(null);
		} 
		else
		{
			let fraction = getToPosition(position);
       		result.push(fraction);
						
		}
	}
	return result;
}

console.log(compute([1, 15, 8, 2]));

console.log(compute([3, 6, -1]));
