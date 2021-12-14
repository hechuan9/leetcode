package g2018.problem328;

import support.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode node = even.next;

        boolean oddFlag = true;
        while (node != null) {
            if (oddFlag) {
                odd.next = node;
                odd = odd.next;
            } else {
                even.next = node;
                even = even.next;
            }
            node = node.next;
            oddFlag = !oddFlag;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}