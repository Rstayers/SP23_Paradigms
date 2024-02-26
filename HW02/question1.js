var users = [
    {id: 1, name: "Marta", height: 1.74, weight: 59}, 
    {id: 2, name: "Josh", height: 1.80, weight: 88},
    {id: 3, name: "Achilles", height: 1.68, weight: 63}, 
    {id: 4, name: "Julius", height: 1.93, weight: 97},
];


function findUserById(users, id)
{
  	//get all matching ids 
    ids = users.filter(users => users.id === id);

	// return null if empty query, else return name
    return ids.length === 0 ? null : ids[0].name;
}

function computeBMIs(users)
{
	//use map to get BMIs
	bmis = users.map(x => x.weight/(x.height*x.height));
    return bmis;
}

//Test cases
console.log(findUserById(users, 2)); // Josh 
console.log(computeBMIs(users));     // [ 19.48, 27.1, 23.3, 26.0 ]
