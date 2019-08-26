package context.problem5052;

import support.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> sums;

    public int maxLevelSum(TreeNode root) {
        sums = new HashMap<>();
        preorder(root, 1);
        int maxLevel = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxLevel = entry.getKey();
            }
        }
        return maxLevel;
    }

    private void preorder(TreeNode node, int level) {
        if (node == null) return;
        sums.put(level, sums.getOrDefault(level, 0) + node.val);
        preorder(node.left, level + 1);
        preorder(node.right, level + 1);
    }
}