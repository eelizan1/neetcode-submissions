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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = root; 

        while (lca != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right; 
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left; 
            } else {
                lca = root; 
                break; 
            }
        }

        return lca; 
    }
}
