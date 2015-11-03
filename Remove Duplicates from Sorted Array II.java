/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

Subscribe to see which companies asked this question
*/

/*
looks simple but hard to figure out the answer
*/







/***********Best solution************/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(j <2 || nums[i] > nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        
        return j;
        
    }
}