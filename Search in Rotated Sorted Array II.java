/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

Subscribe to see which companies asked this question
*/

/************My solution**************/
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0)
            return false;
            
        int low = 0;
        int height = nums.length - 1;
        int mid = 0;
        
        while(low <= height) {
            while(low < height && nums[low] == nums[low + 1]) low++;
            while(low < height && nums[height] == nums[height - 1]) height--;
            mid = (low + height)/2;
            if(nums[mid] == target || nums[low] == target || nums[height] == target)
                return true;
            if(nums[low] < nums[mid]) {// left sorted
                if(target < nums[mid] && target > nums[low]) {
                    while(mid > low && nums[mid] == nums[mid - 1]) mid--;
                        height = mid - 1;
                    
                }
                else {
                    while(mid < height && nums[mid] == nums[mid + 1]) mid++;
                        low = mid + 1;
                }
            }
            
            else {
                if(target > nums[mid] && target < nums[height]) {
                    while(mid < height && nums[mid] == nums[mid + 1]) mid++;
                        low = mid + 1;
                }
                else {
                    while(mid > low && nums[mid] == nums[mid - 1]) mid--;
                        height = mid - 1;
                }
            }
        }
        return false;
    }
}


/**************Others solution********************/
//Handle three case:
public boolean search(int[] A, int target) {
    int start = 0;
    int end = A.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (A[mid] == target) // case 0
            return true;
        // finally start == mid == end, if case 0, return true, else end the loop
        else if (A[start] == A[mid])
            start++;
        else if (A[end] == A[mid])
            end--;
        else if (A[start] <= target && target <= A[mid]) // case 1
            end = mid;
        else if (A[mid] < target && target <= A[end]) // case 2
            start = mid + 1;
        else if (A[start] > A[mid]) // case 2 is false, so target in this range
            end = mid;
        else   // case A[mid] > A[end] and case 1 is false, similar to above
            start = mid + 1;
    }
    return false;
}