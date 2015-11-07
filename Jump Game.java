/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/


/*
I want to use dp but it has O(n) more space and more time spend in fill in 
value


*/


/**********best solution**********/
public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
	}
}	

/**********my solution************/
/*        
        boolean[] table = new boolean[nums.length];
        table[0] = true;
        for(int i = 0; i < nums.length - 1; i++) {
            if(!table[i]) continue;
            if(nums[i]  + i>= nums.length - 1)
                return true;
            else {
                for(int j = 1; j <= nums[i]; j++) {
                    table[i + j] = true;
                }
            }
        }
        
        return table[nums.length - 1];
        
/*       right to left
        if(nums.length == 1)
            return true;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= nums.length - 1)
                table[i] = true;
            else {
                for(int j = 1; j <= nums[i]; j++) {
                    if(table[i + j]) {
                        table[i] = true;
                        break;
                    }
                }
            }
        }
        return table[0];
**/        