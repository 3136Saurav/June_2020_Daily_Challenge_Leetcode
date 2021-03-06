/*
Given a string s and a string t, check if s is subsequence of t.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
**/


class Solution {
    public boolean isSubsequence(String s, String t) {
        int j = 0, i = 0;
        
        if (s.length() == 0)
            return true;
        
        while (i < t.length()){
            // System.out.println("i = " + i + " j = " + j);
            if (t.charAt(i) == s.charAt(j)){
                if (j == s.length() - 1)
                    return true;
                j++;
            }
            i++;
        }
        
        return false;
    }
}
