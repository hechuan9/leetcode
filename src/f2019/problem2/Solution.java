package f2019.problem2;

import support.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                add += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                add += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(add % 10);
            add /= 10;
            node = node.next;
        }
        if (add != 0) node.next = new ListNode(add);
        return head.next;
    }
}