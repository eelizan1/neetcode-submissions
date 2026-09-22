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
        ListNode firstList = head; 
        ListNode secondList = prev; 

        while (secondList != null) {
            ListNode temp1 = firstList.next; 
            ListNode temp2 = secondList.next; 

            firstList.next = secondList; 
            secondList.next = temp1; 

            firstList = temp1; 
            secondList = temp2; 
        }
    }
}
