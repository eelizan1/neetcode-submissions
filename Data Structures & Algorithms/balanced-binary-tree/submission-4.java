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
    public boolean isBalanced(TreeNode root) {
        int res = dfs(root); 

        return res == -1 ? false : true; 
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0; 

        int left = dfs(root.left); 
        int right = dfs(root.right); 
        int difference = Math.abs(left - right); 

        if (difference > 1 || left == -1 || right == -1) {
            return -1; 
        }

        return Math.max(left, right) + 1; 
    }
}
