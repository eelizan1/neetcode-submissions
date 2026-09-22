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
            while(listNode != null) {
                heap.add(listNode.val); 
                listNode = listNode.next; 
            }
         }

         ListNode dummy = new ListNode(); 
         ListNode curr = dummy; 

         while (!heap.isEmpty()) {
            curr.next = new ListNode(heap.remove()); 
            curr = curr.next; 
         }

         return dummy.next; 
    }
}
