
/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/
/************my code *****************/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // validate input 
        if(board.length != 9)
            return false;
        for(int i = 0; i < 9; i++)  {
            if(board[i].length != 9)
            return false;
        }    
            
        boolean[] check;
        char temp = '0';
        int index = 0;
        //check rows
        for(int i = 0; i < 9; i++)  {
            check = new boolean[9];
            for(int j = 0; j < 9; j++)  {
                if(board[i][j] == '.')
                    continue;
                index = board[i][j] - '1';
                if(index < 0 || index > 8 || check[index] == true)
                    return false;
                check[index] = true;
            }
        }
        
        //check columns 
        for(int i = 0; i < 9; i++)  {
            check = new boolean[9];
            for(int j = 0; j < 9; j++)  {
                if(board[j][i] == '.')
                    continue;
                index = board[j][i] - '1';
                if(index < 0 || index > 8 || check[index] == true)
                    return false;
                check[index] = true;
            }
        }
        // check block
        for(int i = 0; i < 9; i+=3)  {
            for(int j = 0; j < 9; j+=3)  {
                check = new boolean[9];
                for(int m = i; m < i + 3; m++)  {
                    for(int n = j; n < j + 3; n++)  {
                        if(board[m][n] == '.')
                            continue;
                        index = board[m][n] - '1';
                        if(index < 0 || index > 8 || check[index] == true)
                            return false;
                        check[index] = true;
                    }
                }
                
            }
        }
        
    return true;
    }
    
    
}


/************better one*****************/
//https://leetcode.com/discuss/23901/my-short-solution-by-c-o-n2
class Solution
{
public:
    bool isValidSudoku(vector<vector<char> > &board)
    {
        int used1[9][9] = {0}, used2[9][9] = {0}, used3[9][9] = {0};

        for(int i = 0; i < board.size(); ++ i)
            for(int j = 0; j < board[i].size(); ++ j)
                if(board[i][j] != '.')
                {
                    int num = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                    if(used1[i][num] || used2[j][num] || used3[k][num])
                        return false;
                    used1[i][num] = used2[j][num] = used3[k][num] = 1;
                }

        return true;
    }
};