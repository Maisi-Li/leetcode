/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/


/*
https://leetcode.com/discuss/15805/accepted-o-n-solution-in-java
*/

/***********my solution***************/
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null)
            return 0;
        int sum = nums[0];
        int max = sum;
        for(int i = 1; i < nums.length; i++)    {
            if(sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            
            if(sum > max)   {
                max = sum;
            }
        }
        return max; 
    }
}

//证明最大子序列不包含和为负数或0的子序列
// http://shmilyaw-hotmail-com.iteye.com/blog/1616632
// 假设i之前的序列< 0, 那么完全可以省略之前的子序列选择之后的几个

/************better one**********/
public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
        maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
        maxSoFar=Math.max(maxSoFar, maxEndingHere); 
    }
    return maxSoFar;
}