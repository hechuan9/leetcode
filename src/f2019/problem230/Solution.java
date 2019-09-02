package f2019.problem230;

import support.TreeNode;

class Solution {
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    private void helper(TreeNode node, int k) {
        if (node == null) return;
        int leftCount = count(node.left);
        if (leftCount + 1 == k) {
            res = node.val;
            return;
        } else if (leftCount + 1 < k) {
            helper(node.right, k - leftCount - 1);
        } else {
            helper(node.left, k);
        }
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }
}
