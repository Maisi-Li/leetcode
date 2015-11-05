/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

/*
The same as 3 sum
*/

/*********my solution********/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int p1 = 0;
        int p2 = len - 1;
        int result = 0;
        
        
        for(int i = 0; i < len; i++)    {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            p1 = i + 1;
            p2 = len - 1;
            sum = target - nums[i];
            while(p1 < p2)  {
                if(Math.abs(sum  - nums[p1] - nums[p2]) < min)  {
                min = Math.abs(sum  - nums[p1] - nums[p2]);
                result = nums[i] + nums[p1] + nums[p2];
            }
                if(nums[p1] + nums[p2] < sum)   {
                    while(p1 < p2 && nums[p1] == nums[p1 + 1])  p1++;
                    p1++;
                }
                else    {
                    while(p1 < p2 && nums[p2] == nums[p2 - 1])  p2--;
                    p2--;
                }
                
            }
            if(min == 0)
            break;
        }
        return result;
    }
}