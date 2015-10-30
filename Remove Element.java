/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

/*
My first thinking is to use two pointer: begin and end to replace certain number

*/

/***********My solution***************/
public class Solution {
    private int len = 0;
    public int removeElement(int[] nums, int val) {

        int l = nums.length;
    for (int i=0; i<l; i++) {
        if (nums[i] == val) {
            nums[i--] = nums[l-- -1];
        }
    }
    return l;
    
}
}