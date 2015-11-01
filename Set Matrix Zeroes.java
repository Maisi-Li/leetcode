/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

/*
Previous solution: O(m + n) space ---- O(mn) time
New solution: O(1) space ---- O(mn) time
*/

/*************Previous solution*************/
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null)
            return ;
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        
        for(int i = 0; i < matrix.length; i++)  {
            for(int j = 0; j < matrix[0].length; j++)   {
                if(matrix[i][j] == 0)   {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        Iterator iterator = row.iterator();
        while(iterator.hasNext())   {
            for(int i = 0; i < matrix[0].length; i++)   {
                matrix[iterator.next()][i] = 0;
            }
        }
        iterator = col.iterator();
        while(iterator.hasNext())   {
            for(int i = 0; i < matrix.length; i++)   {
                matrix[i][iterator.next()] = 0;
            }
        }
        
        
    }
}

/***************New solution*********************/
public class Solution {
public void setZeroes(int[][] matrix) {
    boolean fr = false,fc = false;
    for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] == 0) {
                if(i == 0) fr = true;
                if(j == 0) fc = true;
                matrix[0][j] = 0;
                matrix[i][0] = 0;
            }
        }
    }
    for(int i = 1; i < matrix.length; i++) {
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }
    if(fr) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[0][j] = 0;
        }
    }
    if(fc) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }

}
}