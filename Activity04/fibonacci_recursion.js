function fibonacci(n)
{
	//base cases
   	if (n === 0)
	{
		return 0;
	}
	if (n === 1 || n === 2)
	{
		return 1;
	}
	//recursive case
	return fibonacci(n-1) + fibonacci(n-2);
	
}

//tests
console.log(fibonacci(8)); //21
console.log(fibonacci(20)); //6765
