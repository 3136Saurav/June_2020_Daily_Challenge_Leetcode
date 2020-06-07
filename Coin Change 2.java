/**

You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

**/


class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int result = coinChangeHelper(amount, coins);
        return result;
    }
    
    public int coinChangeHelper(int amount, int[] coins){
        int[][] coinsChangeMatrix = new int[amount+1][coins.length+1];
        coinsChangeMatrix[0][0] = 1;
        
        for(int i=1; i<coins.length+1; i++)
            coinsChangeMatrix[0][i] = 1;
        
        for(int j=1; j<amount+1; j++)
            coinsChangeMatrix[j][0] = 0;
        
        for (int i=1; i<amount+1; i++){
            for (int j=1; j<coins.length+1; j++) {
                coinsChangeMatrix[i][j] = coinsChangeMatrix[i][j-1];
                
                if(coins[j-1] <= i)
                    coinsChangeMatrix[i][j] += coinsChangeMatrix[i - coins[j-1]][j];    
            }
        }
        return coinsChangeMatrix[amount][coins.length];         
    }
}
