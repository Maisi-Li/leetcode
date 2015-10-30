/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.
*/

/*
Kind of the same as unique path I
*/

/************My solution**************/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] count = new int[obstacleGrid.length][obstacleGrid[0].length];
        count[0][0] = 1 - obstacleGrid[0][0];
        // the first row
        for(int i = 1; i < obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] == 1)
                count[0][i] = 0;
            else
                count[0][i] = count[0][i - 1];
        }
        // the first column
        for(int i = 1; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] == 1)
                count[i][0] = 0;
            else
                count[i][0] = count[i - 1][0];
        }
        
        //the rest
        for(int i = 1; i < obstacleGrid.length; i++) {
            for(int j = 1; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1)
                    count[i][j] = 0;
                else
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        
        
        return count[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}


/*****************Better one********************/
// only use one loop to handle all the case
// and do not need extra space
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        //Empty case
        if(obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if(i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;// For row 0, if there are no paths to left cell, then its 0,else 1
                else if(j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;// For col 0, if there are no paths to upper cell, then its 0,else 1
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[rows - 1][cols - 1];

    }
}