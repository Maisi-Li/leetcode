/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/


/***********my solution************/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;
            
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        
        while(rStart <= rEnd && cStart <= cEnd) {// equal to avoid only have one items
            for(int i = cStart; i <= cEnd; i++)
                res.add(matrix[rStart][i]);
            rStart++;
            
            for(int i = rStart; i <= rEnd; i++) 
                res.add(matrix[i][cEnd]);
            cEnd--;
            
            if(rStart <= rEnd) {// if is important!
                for(int i = cEnd; i >= cStart; i--)
                    res.add(matrix[rEnd][i]);
                rEnd--;
            }
            if(cStart <= cEnd) {
                for(int i = rEnd; i >= rStart; i--) 
                    res.add(matrix[i][cStart]);
                cStart++;
            }
        }
        
        return res;
        
    }
}