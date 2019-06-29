package problem230;

import support.TreeNode;

class Solution {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null || count >= k) return;
        inorder(node.left, k);
        count++;
        if (count == k) res = node.val;
        inorder(node.right, k);
    }


}