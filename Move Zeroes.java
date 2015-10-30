/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/


/***************My solution *******************/
// use two pointer to swap value
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                continue;
            j = i > j ? i + 1: j + 1;
            while(j < nums.length && nums[j] == 0)
                j++;
            if(j == nums.length)
                break;
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


/***************Better solution********************/
// Shift non-zero values as far forward as possible
// Fill remaining space with zeros

public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}