


function findMaxConsecutiveNumbers(nums) {
    /* your solution goes here */
				var max_count = 0;
				var curr_count = 0;
				for (var i = 0; i < nums.length; i++) 
				{
					
  				if (nums[i] === 3)
					{
							curr_count++;	
							if(curr_count > max_count)
							{
									max_count = curr_count;
							}
					}
					else
					{
						curr_count = 0;
					}
				}
				return max_count;
}

console.log(findMaxConsecutiveNumbers([3,3,30,3,3,3]));
console.log(findMaxConsecutiveNumbers([3,0,3,3,0,3]));
console.log(findMaxConsecutiveNumbers([3,-10,3,3,8,3,3,3,9,3,3,3,3,3,3]));
console.log(findMaxConsecutiveNumbers([3,3,5,3,3,3]));
console.log(findMaxConsecutiveNumbers([null, "house", 9, undefined, "3"]));

