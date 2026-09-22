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
        // get middle 
        ListNode slow = head; 
        ListNode fast = head; 

        while (fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }

        // reverse second half 
        ListNode curr = slow.next; 
        ListNode prev = null; 
        slow.next = null; 

        while (curr != null) {
            ListNode temp = curr.next; 
            curr.next = prev; 

            prev = curr; 
            curr = temp; 
        }

        // sorted merge 
        ListNode l1 = head; 
        ListNode l2 = prev; 

        while (l1 != null && l2 != null) {
            ListNode t1 = l1.next; 
            ListNode t2 = l2.next; 

            l1.next = l2; 
            l2.next = t1; 

            l1 = t1; 
            l2 = t2; 
        }
    }
}

// 0, 1, 2, 3, 4, 5, 6
// 0, 1, 2, 3
// 6, 5, 4
// 0, 6, 1, 5, 2, 4, 4