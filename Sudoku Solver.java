/*
Sudoku Solver
*/



/**********my solution***********/
public class Solution {
    int[][] grid;
    Stack<Integer> stack;
    List<Integer> list;
    HashMap<Integer, List<Integer>> map;
   public void solveSudoku(char[][] board) {
        grid = new int[board.length][board[0].length];
        stack = new Stack<>();
        list = new ArrayList<>();
        map = new HashMap<>();
        boolean retrace = false;
        int x = 0, y = 0;
        
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(board[i][j] == '.') {
                    grid[i][j] = 0;
                    continue;
                }
                grid[i][j] = board[i][j] - '0';
            }
        }
        
        // findempty grid and fill it with possible value
        while(true) {
            
            if(retrace) {
               // delete the last item in list
               // if list is empty: retrace
               // else: give a new value, start again
               // reset retrace
               if(stack.empty())
                   break;
               if(map.get(stack.peek()).size() == 1) {
                   int pos = stack.pop();
                   grid[pos/10][pos%10] = 0;
               }
                   
               else{
                   int pos = stack.peek();
                   map.get(pos).remove(0);
                   x = pos/10;
                   y = pos%10;
                   grid[x][y] = map.get(pos).get(0);
                   retrace = false;
               }
               
            }
            else{
                // get new pos
                // see if its qualify 
                // add this point to stack and hashmap
                //reset retrace
                int pos = findEmpty(x,y);
                if(pos == -1)
                   break;
                x = pos/10;
                y = pos%10;
                list = new ArrayList<>();
                if(isQualifed(x,y,list)) {
                   if(list.size() == 0) {
                       retrace = true;
                       continue;
                   }
                   map.put(pos, list);
                   stack.push(pos);
                   grid[x][y] = list.get(0);
                }
                else{
                    retrace = true;
                }
            }
      
        }
        
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(board[i][j] == '.') {
                    char temp = (char)(grid[i][j]);
                    board[i][j] = (char) (temp + '0');
                }
            }
        }
        
        return;
        
   }		
   
   
   
   
   // input the x and y to start searching. if we find the number 
   // return x*10 + j . else if we fill all number, return -1;
   private int findEmpty(int x, int y) {
       for(int i = x; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(grid[i][j] == 0) {
                    int position = i*10 + j;
                    return position;
                }
                   
            }
        }
        
        return -1;
   }
   private boolean isQualifed(int x, int y, List<Integer> list) {
       int[] map = new int[10];
       int[] map1 = new int[10];
       int[] map2 = new int[10];
       int[] map3 = new int[10];
       for(int i = 0; i < 9; i++) {
           if(grid[i][y] == 0) continue;
           if(map1[grid[i][y]] == 0) {
               map1[grid[i][y]]++;
               map[grid[i][y]]++;
           }
               
           else
               return false;
       }
       for(int j = 0; j < 9; j++) {
           if(grid[x][j] == 0) continue;
           if(map2[grid[x][j]] == 0) {
               map2[grid[x][j]]++;
               map[grid[x][j]]++;
           }
               
           else 
               return false;
       }
       int baseX = x/3;
       int baseY = y/3;
       for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
               if(grid[i + baseX*3][j + baseY*3] == 0) continue;
               if(map3[grid[i + baseX*3][j + baseY*3]] == 0) {
                   map3[grid[i + baseX*3][j + baseY*3]]++;
                   map[grid[i + baseX*3][j + baseY*3]]++;
               }
                   
               else
               return false;
           }
       }
       
       for(int i = 1; i < 10; i++) {
           if(map[i] == 0)
               list.add(i);
       }
       return true;
   }
}


/***********other solution************/
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9 for each cell
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char c){
        //Check colum
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;

        //Check row
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;

        //Check 3 x 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
}