package f2019.problem124;

import support.TreeNode;

class Solution {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        inorder(root);
        return res;
    }

    private int inorder(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, inorder(node.left));
        int right = Math.max(0, inorder(node.right));
        int max = left + right + node.val;
        res = Math.max(res, max);
        return max;
    }
}