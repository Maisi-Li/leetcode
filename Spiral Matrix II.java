/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

/**************my solution***************/
public class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] m = new int[n][n];
        int count = 1;
        
        for(int i = 0; i < n/2 + 1; i++)    {
            int length = n - 1 - i;//n = 5 len1 = 4 3
            if(i - length >= 0)
                break;
            for(int j = i; j < length; j++)    {
                m[i][j] = count++;
            }
            for(int j = i; j < length; j++) {
                m[j][length] = count++;
            }
            for(int j = length; j >i; j--) {
                m[length][j] = count++;
            }
            for(int j = length; j >i ; j--) {
                m[j][i] = count++;
            }
        }
        if((n&1) == 1)
            m[n>>1][n>>1] = count++;
        return m;
    }
}

/**************better one************/
public static int[][] generateMatrix(int n) {
    int[][] ret = new int[n][n];
    int left = 0,top = 0;
    int right = n -1,down = n - 1;
    int count = 1;
    while (left <= right) {
        for (int j = left; j <= right; j ++) {
            ret[top][j] = count++;
        }
        top ++;
        for (int i = top; i <= down; i ++) {
            ret[i][right] = count ++;
        }
        right --;
        for (int j = right; j >= left; j --) {
            ret[down][j] = count ++;
        }
        down --;
        for (int i = down; i >= top; i --) {
            ret[i][left] = count ++;
        }
        left ++;
    }
    return ret;
}