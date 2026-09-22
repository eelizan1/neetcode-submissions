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
    private int goodNodes = 0; 

    public int goodNodes(TreeNode root) {
        dfs(root, root.val); 

        return goodNodes; 
    }

    private void dfs(TreeNode node, int max) {
        if (node == null) return; 

        if (node.val >= max) {
            max = node.val; 
            goodNodes++; 
        }

        dfs(node.left, max); 
        dfs(node.right, max); 
    }
}
