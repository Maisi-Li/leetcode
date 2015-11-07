/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
*/

/*
2 majority elements at most 
*/

/***********solution*************/
//Boyer-Moore Majority Vote algorithm/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 1, num2 = 1;
        int count1 = 0, count2 = 0;
        List<Integer> res = new ArrayList<>();
        //
        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0) {
                num1 = nums[i];
                count1++;
                while(i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    count1++;
                    i++;
                }
            }
            
            else if(count2 == 0) {
                num2 = nums[i];
                count2++;
                while(i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    count2++;
                    i++;
                }
            }
            
            else if(nums[i] == num1) count1++;
            else if(nums[i] == num2) count2++;
            else if(nums[i] != num1 && nums[i] != num2) {
                count1--;
                count2--;
            }
        }
        //
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num1) count1++;
            else if(nums[i] == num2) count2++;
        }
        
        if(count1 > nums.length/3)
            res.add(num1);
        if(count2 > nums.length/3)
            res.add(num2);
            
        return res;
    }
}

/*********another one***************/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 1, num2 = 1;
        int count1 = 0, count2 = 0;
        List<Integer> res = new ArrayList<>();
        //find these two number
        for(int i = 0; i < nums.length; i++) {
            if(count1 == 0 || nums[i] == num1) {
                num1 = nums[i];
                count1++;
            }
            
            else if(count2 == 0 || nums[i] == num2) {
                num2 = nums[i];
                count2++;
            }
            
            else if(nums[i] != num1 && nums[i] != num2) {
                count1--;
                count2--;
            }
        }
        //see if these numbers match 
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num1) count1++;
            else if(nums[i] == num2) count2++;
        }
        
        if(count1 > nums.length/3)
            res.add(num1);
        if(count2 > nums.length/3)
            res.add(num2);
            
        return res;
    }
}