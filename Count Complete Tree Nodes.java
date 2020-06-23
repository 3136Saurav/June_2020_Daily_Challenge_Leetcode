/**
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

**/



class Solution {
        
    public int countNodes(TreeNode root) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return 0;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            count++;
            
            if (node.left!=null)
                q.add(node.left);
            if (node.right!=null)
                q.add(node.right);
        }
        return count;
    }
}
