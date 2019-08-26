package f2019.problem236;

import support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<TreeNode> pPath;
    List<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q, new LinkedList<>());
        TreeNode lca = root;
        for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
            if (pPath.get(i) != qPath.get(i)) break;
            lca = pPath.get(i);
        }
        return lca;
    }

    private void helper(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (node == null) return;
        path.add(node);
        if (node == p) pPath = new ArrayList<>(path);
        if (node == q) qPath = new ArrayList<>(path);

        helper(node.left, p, q, path);
        helper(node.right, p, q, path);

        path.remove(path.size()-1);
    }
}