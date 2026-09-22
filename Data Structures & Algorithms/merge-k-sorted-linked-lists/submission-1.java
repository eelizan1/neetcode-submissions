/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); 

        for (ListNode listNode : lists) {
            ListNode curr = listNode; 
            while (curr != null) {
                heap.add(curr.val); 
                curr = curr.next; 
            }
        }

        ListNode dummy = new ListNode(); 
        ListNode head = dummy; 

        while (!heap.isEmpty()) {
            ListNode listNode = new ListNode(heap.remove()); 
            head.next = listNode; 
            head = head.next; 
        }

        return dummy.next; 
    }
}
