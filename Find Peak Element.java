/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/



/************my solution***********/
// O(n)
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2)
            return 0;
        int i = 0;   
        if(nums[0] > nums[1])
                return 0;
        for(i = 1; i< nums.length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        
        if(i == nums.length - 1 && nums[i] > nums[i - 1])
                return i;
        return 12345;
        
    }
}

/***************better one****************/
//O(logn)
class Solution {
public:
    int findPeakElement(const vector<int> &num) 
    {
        int low = 0;
        int high = num.size()-1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
};