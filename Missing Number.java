/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/

/*
Three way to do this: 
1. XOR 
2. SUM
3. BINARY SEARCH -- IF THE ARRAY IS SORTED
https://leetcode.com/discuss/56174/3-different-ideas-xor-sum-binary-search-java-code
*/


/*********my solution**********/
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length < 1)
            return 0;
        
        int res = 0;
        int i = 0;
        for(i = 0; i < nums.length; i++)
            res = res ^ i ^ nums[i];
        
        return res ^ i;
    }
    
}