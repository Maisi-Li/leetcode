/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 

Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

/*
There are three way to do this:

1. explore all pairs of two using two for loops - O(n^2)

2. Sort and use two pointer in the beginning and end (nlog(n))

3. Using hashmap to find certain number O(n). but require some extra memory 

In this solution, we use the third one.
*/

public class Solution {
	    public int[] twoSum(int[] array, int target)	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] a = new int[2];
		for(int i = 0; i < array.length; i++)	{
			if(map.containsKey(target - array[i]))	{				
				a[0] = map.get(target - array[i]);
				a[1] = i + 1;
				break;
			}
			map.put(array[i], i + 1);		
		}

        
		return a ;
	}
}


