/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 

For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 




The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

*/
/*
Here is my idea: instead of calculating area by height*width, we can think it in a cumulative way. 
In other words, sum water amount of each bin(width=1). 
Search from left to right and maintain a max height of left and right separately, which is like a one-side wall of partial container. 
Fix the higher one and flow water from the lower part. 
For example, if current height of left is lower, we fill water in the left bin. 
Until left meets right, we filled the whole container.
https://leetcode.com/discuss/16171/sharing-my-simple-c-code-o-n-time-o-1-space
*/
/*****best solution**********/
public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int res = 0;
        while(left < right) {
            if(height[left] <= height[right]) {
                if(maxLeft < height[left])
                    maxLeft = height[left];
                else
                    res += maxLeft - height[left];
                left++;
            }
            else{
                if(maxRight < height[right])
                    maxRight = height[right];
                else
                    res += maxRight - height[right];
                right--;
            }
        }
        
        return res;
    }
}