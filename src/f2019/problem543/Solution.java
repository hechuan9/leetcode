package f2019.problem543;

import support.TreeNode;

class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        traverse(root);
        return max - 1;
    }

    private int traverse(TreeNode node) {
        if (node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}