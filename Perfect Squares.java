/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/




class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        
        for (int i=1; i<=n; i++) {
            int minVal = i;
            int y=1, sq = 1;
            
            while(sq <= i) {
                minVal = Math.min(minVal, 1 + dp[i - sq]);
                y++;
                sq = y*y;
            }
            
            dp[i] = minVal;
        } 
        return dp[n];
    }
}
