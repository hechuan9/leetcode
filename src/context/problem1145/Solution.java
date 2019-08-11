package context.problem1145;

import org.w3c.dom.Node;
import support.TreeNode;

class Solution {
    private int[] counts;
    private TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        counts = new int[n+1];
        int total = countChild(root, x);
        int countNeeded = n % 2 == 0 ? n / 2 + 1 : n / 2;
        if (total - counts[x] >= countNeeded) return true; // pick the parent and win
        if (counts[xNode.left.val] >= countNeeded) return true; // pick left
        if (counts[xNode.right.val] >= countNeeded) return true; // pick left
        return false;
    }

    private int countChild(TreeNode node, int x) {
        int count = 0;
        if (node == null) return 0;
        if (node.val == x) xNode = node;
        count += 1;
        count += countChild(node.left, x);
        count += countChild(node.right, x);
        counts[node.val] = count;
        return count;
    }
}