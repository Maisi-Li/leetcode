/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/



/**************My solution***************/
public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <= 1)
            return ;
        //check the number is ascending from left to right
        int permuteNum = len - 2;
        while(permuteNum >=0 && nums[permuteNum] >= nums[permuteNum + 1])    {
            permuteNum--;
        }
        //if this array is descending, reverse it, than return 
        if(permuteNum < 0) {
            reverseSort(nums, 0, len);
            return;
        }
        //if we find this specifice number
        //1.switch it to a larger one
        int greaterNum = findGreaterNum(nums, permuteNum + 1, nums[permuteNum]);
        swap(nums, greaterNum, permuteNum);
        
        //2.resort the range 
        Arrays.sort(nums, permuteNum + 1, len);
        // reverseSort(nums, permuteNum + 1, len);
    }
    
    
    void reverseSort(int[] nums, int begin, int end)  {
        int temp;
            for(int i = begin; i < (begin + end)/2; i++)  {
                temp = nums[i];
                nums[i] = nums[end - 1 - i];
                nums[end - 1 - i] = temp;
            }
    }
    
    void swap(int [] nums, int a, int b)    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    int findGreaterNum(int[] nums, int begin, int target)   {
        //################如果中间都是重复的数字那么是没办法用二分法找的，暴力查找
        // if(begin = nums.length - 1)
        //     return begin;
        // int low = begin;
        // int hight = nums.length -1;
        // int mid;
        // while(low <= hight) {
        //     mid = (low + hight)/2;
        //     // if(mid == begin || mid == nums.length - 1)
        //     //     return mid;
        //     if(nums[mid] )
        // }
        
        for(int i = begin; i < nums.length - 1; i++)    {
            if(nums[i] > target && nums[i + 1] <= target)
                return i;
        }
        
        return nums.length - 1;
    }
}