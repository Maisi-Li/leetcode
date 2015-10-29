/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

/*
https://leetcode.com/discuss/27387/summary-of-c-solutions
*/

/************My solution**************/
public class Solution {
    public void rotate(int[] nums, int k) {
        //boundary nums.length
        if(nums.length == 0)
            return;
        int len = nums.length;
        k = k%len;
        if(k < 1)
        return;
        
        reverse(nums,0,len - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,len - 1);
        
        return;
        
    }
    
    public void reverse(int[] nums, int begin, int end) {
        int temp = 0;
        for(int i = 0; i <= (end - begin) / 2; i++) {
            temp = nums[begin +i];
            nums[begin + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
	///alternative way to reverse
	public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}