/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
*/

/*
https://leetcode.com/discuss/69424/clean-c-solution-and-explaination-o-mn-space-with-o-1-time
very helpful explanation
*/

/**************best solution**************/
public class NumMatrix {
    private int[][] nums;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        return ;
        
        nums = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 1; i < matrix.length + 1; i++) {
            for(int j = 1; j < matrix[0].length + 1; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return nums[row2 + 1][col2 + 1] - nums[row1][col2 + 1] - nums[row2 + 1][col1] + nums[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);