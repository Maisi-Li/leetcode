/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

/*
It is a two pointer array problem. 

What I thought is to use two pointer one in the end and one at the beginning.

However, There is another clever setting: all begin at the beginning
*/

/***************Best solution***************/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int j = 0;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[j])
                nums[++j] = nums[i];
        }
        return ++j;
    }
}