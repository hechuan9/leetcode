package g2018.problem105;

import support.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private Queue<Integer> queue = new LinkedList<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        for (int i : preorder) queue.offer(i);
        return helper(inorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int left, int right) {
        if (left > right) return null;

        int val = queue.poll();
        TreeNode root = new TreeNode(val);

        if (left == right) return root;

        int mid;
        for (mid = left; mid <= right; mid++) {
            if (inorder[mid] == val) {
                break;
            }
        }

        root.left = helper(inorder, left, mid - 1);
        root.right = helper(inorder, mid + 1, right);

        return root;
    }
}