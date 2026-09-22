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
        HashMap<Node, Node> oldToCopy = new HashMap<>(); 

        Node curr = head; 
        while (curr != null) {
            Node copy = new Node(curr.val); 
            oldToCopy.put(curr, copy);
            curr = curr.next; 
        }

        curr = head; 
        while (curr != null) {
            Node copyOfCurr = oldToCopy.get(curr); 
            copyOfCurr.next = oldToCopy.get(curr.next); 
            copyOfCurr.random = oldToCopy.get(curr.random); 

            curr = curr.next; 
        }

        return oldToCopy.get(head); 
    }
}
