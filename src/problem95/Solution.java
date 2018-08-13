package problem95;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return constructTrees(1, n);
    }

    private List<TreeNode> constructTrees(int left, int right) {
        List<TreeNode> list = new LinkedList<>();
        if (left > right) list.add(null);
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = constructTrees(left, i - 1);
            List<TreeNode> rightList = constructTrees(i + 1, right);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}