/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

/*
* clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
 
*/


/***********My solution**************/
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1)
            return;
        int len = matrix.length - 1;
        int n = matrix.length;
        int temp1, temp2, temp3;
        for(int i = 0; i <= len; i++) {
            for(int j = i; j < len - i; j++) {
                temp1 = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                temp2 = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp1;
                temp3 = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp2;
                matrix[i][j] = temp3;
            }
        }
            
    }
}

/************Better solution*************/
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}