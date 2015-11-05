/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/


/*
multiple left and than right
*/

/**************Solution******************/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        int right = 1, left = 1;
        res[0] = 1;
        for(int i = 1; i < len; i++) {
            res[i] = left*nums[i - 1];
            left = res[i];
        }
        
        for(int i = len - 1; i >=0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        
        return res;
        
    }
}
