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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false; 

        boolean fromRoot = isSameTree(root, subRoot); 

        boolean fromLeft = isSubtree(root.left, subRoot); 
        boolean fromRight = isSubtree(root.right, subRoot); 

        return fromRoot || fromLeft || fromRight; 
    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true; 

        if (node == null || subRoot == null) return false; 

        if (node.val != subRoot.val) return false; 

        return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right); 
    }
}
