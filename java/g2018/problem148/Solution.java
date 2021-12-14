package g2018.problem148;

import support.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = mid(head);
        ListNode rightStart = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightStart);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (left != null && right != null) {
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            } else {
                node.next = left;
                left = left.next;
            }
            node = node.next;

        }
        if (left == null) {
            node.next = right;
        } else {
            node.next = left;
        }
        return dummy.next;
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}