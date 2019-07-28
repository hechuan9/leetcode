package g2018.problem94;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RecursiveSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        inorder(ret, root);
        return ret;
    }

    private void inorder(List<Integer> list, TreeNode node) {
        if (node == null) return;

        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }
}