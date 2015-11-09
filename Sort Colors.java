/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

/***********my solution***************/
//counting sort
public class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                p1++;
                p2++;
            }
            else if(nums[i] == 1)
                p2++;
        }
        
        int i = 0;
        while(i < p1) nums[i++] = 0;
        while(i < p2) nums[i++] = 1;
        while(i < nums.length) nums[i++] = 2;
        
    }
}

/************better one****************/
//c++
 class Solution {
    public:
        void sortColors(int A[], int n) {
            int second=n-1, zero=0;
            for (int i=0; i<=second; i++) {
                while (A[i]==2 && i<second) swap(A[i], A[second--]);
                while (A[i]==0 && i>zero) swap(A[i], A[zero++]);
            }
        }
    };