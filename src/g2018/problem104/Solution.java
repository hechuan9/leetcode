package g2018.problem104;

import support.TreeNode;

class Solution {
    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        inOrder(root, 1);
        return maxDepth;
    }

    private void inOrder(TreeNode node, int depth) {
        if (node == null) return;
        maxDepth = Math.max(depth, maxDepth);
        inOrder(node.left, depth + 1);
        inOrder(node.right, depth + 1);
        return;
    }
}