package problem102;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        List<TreeNode> thisLevel = new LinkedList<>();
        thisLevel.add(root);
        while (!thisLevel.isEmpty()) {
            List<TreeNode> newLevel = new LinkedList<>();
            List<Integer> levelVals = new LinkedList<>();
            for (TreeNode node : thisLevel) {
                if (node == null) continue;
                levelVals.add(node.val);
                if (node.left != null) newLevel.add(node.left);
                if (node.right != null) newLevel.add(node.right);
            }
            thisLevel = newLevel;
            res.add(levelVals);
        }
        return res;
    }
}