package f2019.problem426;

class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node prev;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        Node head = new Node();
        prev = head;
        inorder(root);
        Node first = head.right;
        prev.right = first;
        first.left = prev;
        return first;
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        inorder(node.right);
    }
}