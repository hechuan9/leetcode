package f2019.problem94;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}