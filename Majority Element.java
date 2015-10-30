/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

/*
There are two ways to do:
1. quicksort
2. ~~~ - O(n) time, O(1)space
*/

/*********Best solution*********/
public class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // return nums[nums.length/2];
        //作弊行为哈哈
        
        // 因为 majority element 的数大于一般，我们可以认为任意一个数为-1， 主要数为1
        int major = nums[0];
        int count = 1;
        
        for(int i = 1; i <nums.length; i++) {
            if(count == 0)  {
                count++;
                major = nums[i];
            }
            else if(major == nums[i])
                count++;
            else
                count--;
        }
        
        return major;
    }
}