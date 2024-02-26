let fibonacci = function ()
{
		let n = 0;
		return () =>
		{
			if (n === 0)
        	{
				n +=1;
    			return 0;
        	}
        	else if (n === 1) {
				n +=1;
        		return 1;
        	}
        	else if (n === 2)
        	{
				n +=1;
        		return 1;
        	}

        	let prev = 0;
        	let curr = 1;

        	for (let i = 2; i <= n; i++) {
        		const next = prev + curr;
        		prev = curr;
        		curr = next;
        	}
			n += 1;
        	return curr;

       	}
}
let fibGenerator1 = fibonacci(); // fibonacci() returns a closure
let fibGenerator2 = fibonacci(); // fibonacci() returns a closure

console.log(fibGenerator1()); // prints 0, i.e., F(0)
console.log(fibGenerator1()); // prints 1, i.e., F(1)
console.log(fibGenerator1()); // prints 1, i.e., F(2)
console.log(fibGenerator1()); // prints 2, i.e., F(3)
console.log(fibGenerator1()); // prints 3, i.e., F(4)

console.log(fibGenerator2()); // prints 0, i.e., F(0)
console.log(fibGenerator2()); // prints 1, i.e., F(1)
console.log(fibGenerator2()); // prints 1, i.e., F(2)
console.log(fibGenerator2()); // prints 2, i.e., F(3)
console.log(fibGenerator2()); // prints 3, i.e., F(4)
