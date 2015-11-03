/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/


/*
There are two way to solve this problem:
1.find a target number and expand it to a range: average O(lg(n)) worse O(n)
2.find the left one and than find the right one: average O(lg(n)) worse O(lg(n))
*/

/***********First solution**************/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};// the way to initialize array
        
        int low = 0;
        int height = nums.length - 1;
        int mid = 0;
        
        while(low <= height) {
            mid = (low + height)/2;
            if(nums[mid] == target)
                break;
            else if(nums[mid] < target)
                low = mid + 1;
            else
                height = mid - 1;
            
        }
        
        if(nums[mid] != target)
            return result;
        else {
            low = mid;
            while(low > 0 && nums[low] == nums[low - 1]) low--;
            result[0] = low;
            height = mid;
            while(height < nums.length - 1 && nums[height] == nums[height + 1]) height++;
            result[1] = height;
            return result;
        }
        
    }
}

/**************Second solution****************/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = 0, right = nums.length - 1,mid = 0;
        // find left
        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target) {
                if(mid == 0 || (mid != 0 && nums[mid - 1] < target)) {
                    res[0] = mid;
                    break;
                }
                else {
                    right = mid - 1;
                    continue;
                }
                    
            }
            
            else if (nums[mid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        
        left = 0;
        right = nums.length - 1;
        //find right
        while(left <= right) {
            mid = (left + right)/2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || (mid != nums.length - 1 && nums[mid + 1] > target)) {
                    res[1] = mid;
                    break;
                }
                else {
                    left = mid + 1;
                    continue;
                }
                    
            }
            
            else if (nums[mid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
        }
      
        return res;
    }
}
