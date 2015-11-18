/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

Subscribe to see which companies asked this question
*/

/**********my solution*********/
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int height = 0;
        for(int i:nums) {
            if(i > height)
                height = i;
        }
        if(height == 0)
            return 1;
        boolean[] exist = new boolean[height + 1];
        exist[0] = true;
        
        for(int i:nums) {
            if(i > 0)
                exist[i] = true;
        }
        for(int i = 1; i < exist.length; i++) {
            if(!exist[i]) 
                return i;
        }
        
        return height + 1;
        
    }
}

/***********better one***********/
public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}