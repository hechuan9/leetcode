package f2019.problem98;

import support.TreeNode;

class Solution {
    private Integer trace;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        boolean left = inorder(node.left);
        if (trace != null && node.val <= trace) return false;
        trace = node.val;
        boolean right = inorder(node.right);
        return left && right;
    }
}