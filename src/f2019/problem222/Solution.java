package f2019.problem222;

import support.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        if (leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftHeight(TreeNode node) {
        int height = 1;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height - 1;
    }

    private int rightHeight(TreeNode node) {
        int height = 1;
        while (node != null) {
            node = node.right;
            height++;
        }
        return height - 1;
    }
}