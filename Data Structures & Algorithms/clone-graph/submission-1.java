/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null; 

        HashMap<Node, Node> map = new HashMap<>(); 
        Queue<Node> q = new LinkedList<>(); 
        q.add(node); 

        Node head = new Node(node.val, new ArrayList<>()); 
        map.put(node, head); 

        while (!q.isEmpty()) {
            int size = q.size(); 
            for (int i = 0; i < size; i++) {
                Node currNode = q.remove(); 

                for (Node neighbor : currNode.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val, new ArrayList<>())); 
                        q.add(neighbor); 
                    }

                    Node currCloned = map.get(currNode); 
                    Node clonedNeighbor = map.get(neighbor); 
                    currCloned.neighbors.add(clonedNeighbor); 
                }
            }
        }

        return head; 
    }
}