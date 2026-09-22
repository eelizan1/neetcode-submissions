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
        if (root == null) return null; 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root); 

        while (!q.isEmpty()) {
            int n = q.size(); 
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.remove(); 
                TreeNode currLeft = curr.left; 

                curr.left = curr.right; 
                curr.right = currLeft; 

                if (curr.left != null) q.add(curr.left); 
                if (curr.right != null) q.add(curr.right); 
            }
        }

        return root; 
    }
}
