/**
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
**/


class Solution {
    
    public void dfs(char[][] board, int r, int c) {
        if (r<0 || r>board.length-1 || c<0 || c>board[0].length-1) return;
        
        if (board[r][c] == 'O') board[r][c] = '*';
        
        if (r>1 && board[r-1][c]=='O')
            dfs(board, r-1, c);
      
        if (r<board.length-2 && board[r+1][c]=='O')
            dfs(board, r+1, c);
        
        if (c>1 && board[r][c-1]=='O')
            dfs(board, r, c-1);
        
        if (c<board[r].length-2 && board[r][c+1]=='O')
            dfs(board, r, c+1);
        
        return;
    }
    
    
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        
        int rows = board.length;
        int columns = board[0].length;
        
        for (int j=0; j<columns; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);
            
            if (board[rows-1][j] == 'O')
                dfs(board, rows-1, j);
        }
        
        for (int i=0; i<rows; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            
            if (board[i][columns-1] == 'O')
                dfs(board, i, columns-1);
        }
        
//         for (int i=0; i<board.length; i++) {
//             for (int j=0; j<board[0].length; j++) {
//                 System.out.print(board[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == '*')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
