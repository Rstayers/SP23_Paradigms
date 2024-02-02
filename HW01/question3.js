
function getToPosition(position)
{
	//current array position	
	var i = 0;
	var j = 0;
	//position counter
	var total = 1;
	//current bounds
	var rowStop = 0;
	var colStop = 0;

	out: while (total < position)
	{
		//increase bounds and move down 
		colStop++;
		rowStop++;
		i++;
		total++;
		if (total === position){ break out; };

		//snake up diagonally
		while (i > 0 && j < colStop)
		{
			i--;
			j++;
			total++;
			if (total === position){ break out;}
		}
		//increase bounds and move right
		colStop++;
		rowStop++;
		j++;
		total++;
		if (total === position){ break out; };

		//snake down diagonally
		while (i < rowStop && j > 0)
		{
			i++;
			j--;
			total++;
			if (total === position){ break out;}	
		}

	}
	//return the row+1  as numerator * 2 and col+1  as denom * 2
	return `${(i+1)*2}/${(j+1)*2}`;
}

function compute(termPositions) 
{
   
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
