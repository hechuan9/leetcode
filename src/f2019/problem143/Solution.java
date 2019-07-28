package f2019.problem143;

import support.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // cut the list
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode head2 = p1.next;
        p1.next = null;
        p2 = head2.next;
        head2.next = null;

        // reverse the list
        while (p2 != null) {
            p1 = p2.next;
            p2.next = head2;
            head2 = p2;
            p2 = p1;
        }

        // merge two lists
        p1 = head;
        p2 = head2;
        while (p1 != null) {
            ListNode tmp = p1.next;
            p1.next = p2;
            p1 = p2;
            p2 = tmp;
        }
    }
}