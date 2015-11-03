/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/


/***************My solution******************/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return true;
        int low = 0;
        int height = matrix.length - 1;
        int mid = (low + height)/2;
        int rightMid = 0;
        
        while(low <= height) {
            mid = (low + height)/2;
            if(matrix[mid][0] == target)
                return true;
            if(mid == matrix.length - 1)
                break;
            if(matrix[mid][0] < target && matrix[mid + 1][0] > target)
                break;
            if(matrix[mid][0] > target) {
                height = mid - 1;
            }
            else    {
                low = mid + 1;
            }
        }
        if(matrix[rightMid][0] > target)
            return false;
        // get a right mid 
        rightMid = mid;
        low = 0;
        height = matrix[0].length - 1;
        while(low <= height) {
            mid = (low + height)/2;
            if(matrix[rightMid][mid] == target) 
                return true;
            if(matrix[rightMid][mid] > target)
                height = mid - 1;
            else
                low = mid + 1;
        }
        
        return false;
        
    }
}

/***************Better solution******************/
// treat it like an array 
//https://leetcode.com/discuss/10735/dont-treat-it-as-a-2d-matrix-just-treat-it-as-a-sorted-list/

public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int start = 0, rows = matrix.length, cols = matrix[0].length;
            int end = rows * cols - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[mid / cols][mid % cols] == target) {
                    return true;
                } 
                if (matrix[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }