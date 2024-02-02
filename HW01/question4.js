function reversedSum(num1, num2) 
{
    // Function to reverse a number and remove leading zeros
    function reverseNumber(num) 
		{
        const reversed = parseInt(num.toString().split('').reverse().join(''));
        return reversed;
    }

    // Reverse the input numbers
    const reversedNum1 = reverseNumber(num1);
    const reversedNum2 = reverseNumber(num2);

    // Calculate the sum of the reversed numbers
    const sum = reversedNum1 + reversedNum2;

    // Reverse the sum and return it
    const reversedSum = reverseNumber(sum);

    return reversedSum;
}

// Test cases
console.log(reversedSum("24", 1));    
console.log(reversedSum(4358, "754")); 
console.log(reversedSum(305, 794));    
