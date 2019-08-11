package f2019.problem270;

import support.TreeNode;

class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        int closest = 0;
        double distance = Long.MAX_VALUE;
        while (node != null) {
            if (Math.abs(node.val - target) < distance) {
                distance = Math.abs(node.val - target);
                closest = node.val;
            }
            if (target == node.val) {
                return node.val;
            } else if (target > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return closest;
    }
}