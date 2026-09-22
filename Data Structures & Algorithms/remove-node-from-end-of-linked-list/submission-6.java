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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int listSize = 0; 
        ListNode curr = head; 

        while (curr != null) {
            listSize++; 
            curr = curr.next; 
        }

        if (listSize == n) return head.next; 

        curr = head; 
        ListNode prev = null; 
        int pointer = 0; 
        while (curr != null) {

            if (pointer == listSize - n) {
                prev.next = curr.next;

                break;
            }

            // advance pointers 
            prev = curr; 
            curr = curr.next; 
            pointer++; 
        }

        return head; 
    }
}

// 1. Get list size 
// 2. iterate up to list size - n 
// 3. remove nth node 