/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
*/

class Solution {
    List<String> list = new ArrayList<>();
    
    public void dfs(TreeNode root, String path) {
        if (root == null)
            return;
        
        else if (root.left == null && root.right ==null)
            list.add(path + root.val);
        
        else {
            dfs(root.left, path + root.val);
            dfs(root.right, path + root.val);
        }
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        
        dfs(root, "");
        int total = 0;
        for (String i: list) {
            total += Integer.valueOf(i);
            // System.out.println(list);
        }
        return total;
    }
}
