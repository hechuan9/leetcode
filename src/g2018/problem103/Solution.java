package g2018.problem103;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        List<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        boolean odd = true;

        while (!curLevel.isEmpty()) {
            List<Integer> levelRes = new LinkedList<>();
            List<TreeNode> nextLevel = new LinkedList<>();
            for (TreeNode node : curLevel) {
                if (odd) levelRes.add(node.val);
                else levelRes.add(0, node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            res.add(levelRes);
            curLevel = nextLevel;
            odd = !odd;
        }

        return res;
    }
}