/*
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        
        if(n == 1 || n == 2)
            return true;
        
        while(n!=0){
            if(n%2 != 0 && n != 1)
                return false;
            n = n/2;    
        }
        return true;
    }
}
