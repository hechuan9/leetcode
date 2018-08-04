package problem108;

import support.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = contructTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode contructTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = contructTree(nums, left, mid - 1);
        node.right = contructTree(nums, mid + 1, right);
        return node;
    }
}