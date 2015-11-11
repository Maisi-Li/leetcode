/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

/***********my solution***********/
public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2)
            return 0;
        int low = 0;
        int hi = height.length - 1;
        int max = 0;
        while(low < hi) {
            max = findMaxInTwo(max, (hi - low) * min(height[low], height[hi]));
            if(height[hi] > height[low])
                low++;
            else
                hi--;
        }
        
        return max;
    }
    
    private int findMaxInTwo(int m1, int m2)    {
        return m1>m2?m1:m2;
    }
    
    private int min(int m1, int m2) {
        return m1>m2?m2:m1;
    }
}