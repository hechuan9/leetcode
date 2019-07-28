package g2018.problem116;

import support.TreeLinkNode;

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        travel(root.left, root.right);
        travel(root.right, null);
    }

    private void travel(TreeLinkNode node, TreeLinkNode next) {
        if (node == null) return;

        travel(node.left, node.right);

        if (next == null) travel(node.right, null);
        else travel(node.right, next.left);


        node.next = next;
    }
}