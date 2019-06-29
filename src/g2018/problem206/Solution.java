package g2018.problem206;

import support.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode reverse = null;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = reverse;
            reverse = node;
            node = nextNode;
        }
        return reverse;
    }
}