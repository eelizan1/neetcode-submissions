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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); 
        serializeHelper(root, sb); 
        
        return sb.toString(); 
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,"); 
            return; 
        }

        sb.append(String.valueOf(node.val)); 
        sb.append(","); 

        serializeHelper(node.left, sb); 
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(); 
        q.addAll(Arrays.asList(data.split(","))); 

        return deserializeHelper(q); 
    }

    private TreeNode deserializeHelper(Queue<String> q) {
        String val = q.remove(); 
        if (val.equals("N")) {
            return null; 
        }

        TreeNode node = new TreeNode(Integer.valueOf(val)); 

        node.left = deserializeHelper(q); 
        node.right = deserializeHelper(q); 

        return node; 
    }
}
