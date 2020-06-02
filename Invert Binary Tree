/**
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
**/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(treeQueue.isEmpty() == false){
            // TreeNode curr = treeQueue.peek();
            // treeList.remove();
            TreeNode curr = treeQueue.poll();
            
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null)
                treeQueue.add(curr.left);
            if(curr.right != null)
                treeQueue.add(curr.right);
        }
        return root;
    }
    
