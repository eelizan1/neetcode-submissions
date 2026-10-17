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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap 

        dfs(root, pq); 

        for (int i = 0; i < k - 1; i++) {
            pq.poll(); 
        }

        return pq.peek(); 
    }

    private void dfs(TreeNode node, PriorityQueue<Integer> pq) {
        if (node == null) return; 

        pq.add(node.val); 

        dfs(node.left, pq); 
        dfs(node.right, pq); 
    }
}
