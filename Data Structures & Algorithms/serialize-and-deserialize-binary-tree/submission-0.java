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
        List<String> list = new ArrayList<>(); 
        dfs(root, list); 
        String result = String.join(",", list); 

        return result; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(); 
        q.addAll(Arrays.asList(data.split(","))); 
        return deserializeHelper(q); 
    }

    private TreeNode deserializeHelper(Queue<String> q) {
        String currVal = q.remove(); 

        if (currVal.equals("N")) return null; 

        TreeNode node = new TreeNode(Integer.valueOf(currVal)); 

        node.left = deserializeHelper(q); 
        node.right = deserializeHelper(q); 

        return node; 
    }

    private void dfs(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("N"); 
            return; 
        }

        list.add(String.valueOf(node.val)); 

        dfs(node.left, list); 
        dfs(node.right, list); 
    }
}
