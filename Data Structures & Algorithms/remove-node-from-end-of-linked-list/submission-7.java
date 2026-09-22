class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            curr = curr.next;
            length++;
        }

        ListNode dummy = new ListNode(0, head);
        curr = dummy;

        int stepsBeforeTarget = length - n; // from dummy, this lands one node before the target
        for (int i = 0; i < stepsBeforeTarget; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }
}