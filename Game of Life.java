/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

/*
increase  into 4 state
*/

/*my solution*/
public class Solution {
    public void gameOfLife(int[][] board) {
        /*
            0 d d
            1 l d
            2 d l
            3 l l
        */
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int count = 0;
                for(int k = 0; k < 8; k++) {
                    int x = i + dx[k]; 
                    int y = j + dy[k];
                    if(x >= 0 && x < board.length && y>=0 && y < board[0].length && board[x][y]%2 == 1)
                        count++;
                }
 //               board[i][j] = count;
                if(board[i][j] == 1) {
                    if(count < 2 || count > 3)
                        board[i][j] = 1;
                    else
                        board[i][j] = 3;
                }
                else{
                    if(count == 3)
                    board[i][j] = 2;
                else
                    board[i][j] = 0; 
                }
                    
            }
            
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] <2)
                    board[i][j] = 0;
                else
                    board[i][j] = 1;
            }
        }
       
    }
}

