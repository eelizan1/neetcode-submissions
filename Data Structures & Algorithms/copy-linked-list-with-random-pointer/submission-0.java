/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>(); 
        Node current = head; 

        while (current != null) {
            Node copy = new Node(current.val); 
            map.put(current, copy); 
            current = current.next; 
        }

        current = head; 
        while (current != null) {
            Node copyOfCurrent = map.get(current);
            copyOfCurrent.next = map.get(current.next); 
            copyOfCurrent.random = map.get(current.random); 

            current = current.next; 
        }

        return map.get(head); 
    }
}
