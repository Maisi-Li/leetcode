/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/


/*
similar to unique path
*/

/*******my solution*******/
//not that great
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int row = grid.length;
        int column = grid[0].length;
        
        int[][] minSum = new int[row][column];
        minSum[row - 1][column - 1] = grid[row - 1][column - 1];
        for(int i = row - 2; i>=0; i--)    {
            minSum[i][column - 1] = grid[i][column - 1] + minSum[i + 1][column - 1];
        }
        for(int i = column - 2; i >= 0; i--) {
            minSum[row - 1][i] = grid[row - 1][i] + minSum[row - 1][i + 1];
        }
        
        for(int i = row - 2; i >= 0; i--)    {
            for(int j = column - 2; j >= 0; j--) {
                minSum[i][j] = Math.min(minSum[i][j + 1], minSum[i + 1][j]) + grid[i][j];
            }
        }
        return minSum[0][0];
        
    }
}

// 其实从左上到右下和从右下到左上的结果是一样的