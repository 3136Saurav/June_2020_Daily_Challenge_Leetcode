/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
*/



class Solution {
    
//     int paths = 0;
//     public void dfsRecursive(int m, int n, int i, int j, boolean[][] visited) {
//         if (i == m-1 && j == n-1)
//             paths++;
        
//         if (i >= m || j >= n || visited[i][j])
//             return; 
        
//         visited[i][j] = true;
        
//         dfs(m, n, i+1, j, visited);
//         dfs(m, n, i, j+1, visited);  
        
//         visited[i][j] = false;
//     }
    
    public int uniquePathsDP(int m, int n) {
        int dp[][] = new int[m][n];
        
        for (int i=0; i<m; i++) {
            dp[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public int uniquePaths(int m, int n) {
        // boolean[][] visited = new boolean[m][n];
        return uniquePathsDP(m, n);
        
    }
}
