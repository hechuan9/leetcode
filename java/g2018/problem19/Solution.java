package g2018.problem19;

import support.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        backtrace(dummy, n);
        return dummy.next;
    }

    private int backtrace(ListNode node, int n) {
        if (node.next == null) return 0;
        int countFromBack = backtrace(node.next, n) + 1;
        if (countFromBack == n) node.next = node.next.next;
        return countFromBack;
    }
}