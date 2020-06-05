/*
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]

*/

class Solution {
    
    int[] wSums;
    Random random;
    
    public Solution(int[] w) {
        this.random = new Random();
        this.wSums = new int[w.length];
        for (int i=1; i<w.length; i++)
            w[i] += w[i-1];
        this.wSums = w;
    }
    
    public int pickIndex() {
        int len = wSums.length;
        int key = random.nextInt(wSums[len-1]) + 1;
        int left = 0, right = len-1;
        while (left < right){
            int mid = left + (right - left)/2;
            
            if(key == wSums[mid])
                return mid;
            else if(key > wSums[mid])
                left = mid + 1;
            else
                right = mid;           
        }
        return left;
    }
}
