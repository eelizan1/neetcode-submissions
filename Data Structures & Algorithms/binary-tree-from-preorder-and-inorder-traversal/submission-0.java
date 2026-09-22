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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) return null; 

        int currVal = preorder[0]; 
        TreeNode root = new TreeNode(currVal); 

        int mid = getMid(inorder, currVal); 
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid); 
        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, inorder.length); 

        int[] leftPredOrder = Arrays.copyOfRange(preorder, 1, leftInOrder.length + 1); 
        int[] rightPreOrder = Arrays.copyOfRange(preorder, leftInOrder.length + 1, preorder.length); 

        root.left = buildTree(leftPredOrder, leftInOrder); 
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root; 
    }

    private int getMid(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) return i; 
        }

        return -1; 
    }
}
