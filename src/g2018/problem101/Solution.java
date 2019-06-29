package g2018.problem101;

import support.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetricTravel(root.left, root.right);
    }

    public boolean symmetricTravel(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        if (left.val != right.val) return false;
        return symmetricTravel(left.left, right.right) && symmetricTravel(left.right, right.left);
    }
}