package f2019.problem708;

class Solution {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal, null);

        if (head == null) {
            node.next = node;
            return node;
        }
        Node prev = head;
        Node curr = head.next;

        while (curr.val >= prev.val && curr != head) { // need to circle around
            curr = curr.next;
            prev = prev.next;
        }

        if (insertVal < prev.val) {
            while (curr.val < insertVal) {
                curr = curr.next;
                prev = prev.next;
            }
        }

        prev.next = node;
        node.next = curr;

        return head;
    }
}