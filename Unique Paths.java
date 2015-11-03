/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/


// another simple one 

/**************My solution******************/
public class Solution {
    public int uniquePaths(int m, int n) {
            int[] matrix = new int[m*n];
            for(int i =0; i < n ; i++)   {
                matrix[i] = 1;
            }
            
            for(int i = 1; i < m; i++)  {
                matrix[i*n] = 1;
            }
            
            for(int i = 1; i < m; i++)  {
                for(int j = 1; j < n;j++)   {
                    matrix[i*n + j] = matrix[(i - 1)*n + j] + matrix[i*n + j - 1];
                }
            }
            
            return matrix[m*n - 1];
        // if(min(m,n) == 1)
        //     return 1;
        // return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        
    }
    
    // private int min(int x, int y)   {
    //     return x<y?x:y;
    // }
    
}