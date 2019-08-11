package f2019.problem173;

import support.TreeNode;

import java.util.Stack;

class BSTIterator {

    private Stack<TreeNode> tracer = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            tracer.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = tracer.pop();
        int res = node.val;
        node = node.right;
        while (node != null) {
            tracer.push(node);
            node = node.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !tracer.isEmpty();
    }
}