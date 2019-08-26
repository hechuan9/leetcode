package context.problem1171;

import support.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node != null) {
            node = dummy;
            HashMap<Integer, ListNode> map = new HashMap<>();
            int cummulativeSum = 0;
            while (node != null) {
                cummulativeSum += node.val;
                System.out.println(node.val+":"+cummulativeSum);
                if (map.containsKey(cummulativeSum)) {
                    System.out.println(map.get(cummulativeSum).val);
                    map.get(cummulativeSum).next = node.next;
                    break;
                }

                map.put(cummulativeSum, node);
                node = node.next;
            }
        }

        return dummy.next;
    }
}