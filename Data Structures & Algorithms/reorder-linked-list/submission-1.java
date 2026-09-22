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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find second half - fast and slow pointer 
        ListNode slow = head; 
        ListNode fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        // reverse second half 
        ListNode current = slow.next; 
        slow.next = null; 
        ListNode prev = null;
        
        while (current != null) {
            ListNode temp = current.next; 
            current.next = prev; 
            prev = current; 
            current = temp; 
        }

        // traverse two halfs and merge 
        // [0, 1, 2, 3, 4, 5, 6]
        // [0, 1, 2, 3] => head 
        // [6, 5, 4] => prev 

        // 3. Merge the two halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
