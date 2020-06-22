/*
The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"
*/

class Solution {
    private int fact[] = new int[10];
    private List<Integer> digits = new ArrayList<>();
    
    List<Character> result = new ArrayList<>();
        
    public void solve(StringBuilder ans, int n, int k) {
        if (n == 1) {
            Integer u = digits.get(digits.size()-1);
            ans.append(u);
            return; 
        }
        
        int index = k/fact[n-1];
        
        if (k%fact[n-1] == 0)
            index = index - 1;
        
        ans.append(digits.get(index));
        digits.remove(index);
        
        k = k - fact[n-1] * index;
        solve(ans, n-1, k);
        
    }
    
    public String getPermutation(int n, int k) {
        
        StringBuilder ans = new StringBuilder("");
        fact[0] = 1;
        
        for (int i=1; i<10; i++)
            fact[i] = i * fact[i-1];
        
        for (int i=1; i<=n; i++)
            digits.add(i);
        
        solve(ans, n, k);
        String result = ans.toString();
        return result;
        
    }
}
