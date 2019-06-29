package problem94;

import support.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) return ret;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();

            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }

            while (!stack.empty()) {
                node = stack.pop();
                ret.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    break;
                }
            }

        }
        return ret;
    }
}
