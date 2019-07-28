package f2019.problem199;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            res.add(queue.peek().val);
            for (TreeNode node : queue) {
                if (node.right != null) nextQueue.add(node.right);
                if (node.left != null) nextQueue.add(node.left);
            }
            queue = nextQueue;
        }

        return res;
    }
}