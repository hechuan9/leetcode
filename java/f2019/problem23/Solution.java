package f2019.problem23;

import support.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode dummy = new ListNode(0);

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode list : lists) {
            if (list == null) continue;
            pq.add(list);
        }

        ListNode node = dummy;
        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            ListNode next = list.next;
            node.next = list;
            list.next = null;
            node = list;
            if (next != null) {
                pq.add(next);
            }
        }

        return dummy.next;
    }
}