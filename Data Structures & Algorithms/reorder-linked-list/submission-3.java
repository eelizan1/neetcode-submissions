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
        if (head ==null || head.next == null) return; 

        ListNode fast = head; 
        ListNode slow = head; 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        ListNode curr = slow.next; 
        ListNode prev = null; 
        slow.next = null; 
        while (curr != null) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        }

        ListNode secondList = prev; 
        ListNode firstList = head; 

        while(secondList != null) {
            ListNode temp1 = firstList.next; 
            ListNode temp2 = secondList.next; 

            firstList.next = secondList; 
             secondList.next = temp1;  

            firstList = temp1; 
            secondList = temp2; 
        }
    }
}
