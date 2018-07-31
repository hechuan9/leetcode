package problem160;

import support.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a!=null) {
            lenA++;
            a = a.next;
        }
        while (b!=null) {
            lenB++;
            b = b.next;
        }

        a = headA;
        b = headB;
        if (lenA < lenB) {
            for (int i=0;i<lenB-lenA;i++) {
                b = b.next;
            }
        } else {
            for (int i=0;i<lenA-lenB;i++) {
                a = a.next;
            }
        }

        while (a!=null&&a!=b ) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}