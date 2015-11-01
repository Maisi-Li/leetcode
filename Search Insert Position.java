/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/


/*
Easy one
*/


/*******************My solution********************/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        //check if the array is null
        // get the medium of this array and compare with target
        // reduce the scale of search
        // once small > large jumpout 
        
        // return
        
        if(nums == null || nums[0] > target)
            return 0;
        if(nums[nums.length - 1] < target)
            return nums.length;
        
            
        int begin = 0;
        int end = nums.length - 1;
        int med;
        
        while(begin <= end)  {
            med = (begin + end)/2;
            if(nums[med] == target)
                return med;
            else if(nums[med] > target) 
                end = med - 1;
            else
                begin = med + 1;
        }
        
        return begin ;
        
    }
}