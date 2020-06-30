class Solution {
    HashSet<String> list = new HashSet<>();
    
    public boolean dfs(char[][] board, String str, int i, int r, int c, boolean[][] visited) {
        if (i == str.length())
            return true;
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || str.charAt(i) != board[r][c]|| visited[r][c])
            return false;
        
        visited[r][c] = true;
        
        if (dfs(board, str, i+1, r+1, c, visited) || dfs(board, str, i+1, r-1, c, visited) || dfs(board, str, i+1, r, c-1, visited) || dfs(board, str, i+1, r, c+1, visited)) 
            return true;
        
        visited[r][c] = false;
        
        return false;
        
    }
    
    public void resetVisited(boolean[][] visited) {
        for (boolean[] v : visited) 
            Arrays.fill(v, false);
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null && board.length == 0)
            return new ArrayList<>();
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        int k = 0;
        for (String str: words) {
            for (int i=0; i<board.length; i++) {
                for (int j=0; j<board[0].length; j++) {
                    if (str.charAt(0) == board[i][j] && dfs(board, str, k, i, j, visited))
                        list.add(str);
                }
            }
            resetVisited(visited);
        }
        
        return new ArrayList<>(list);
    }
}
