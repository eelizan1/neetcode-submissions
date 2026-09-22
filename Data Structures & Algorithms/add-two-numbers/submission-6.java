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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0); 
    }

    public ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null; 

        int val1 = l1 == null ? 0 : l1.val; 
        int val2 = l2 == null ? 0 : l2.val;

        int sum = val1 + val2 + carry; 
        int nextCarry = sum > 9 ? 1 : 0; 
        int digit = sum % 10; 

        ListNode resultNode = new ListNode(digit); 

        ListNode nextl1 = l1 == null ? null : l1.next; 
        ListNode nextl2 = l2 == null ? null : l2.next; 

        resultNode.next = add(nextl1, nextl2, nextCarry); 

        return resultNode; 
    }
}
