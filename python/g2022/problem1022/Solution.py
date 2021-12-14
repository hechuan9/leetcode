# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        num = 0
        def preorder(node, val):
            nonlocal num
            if node == None:
                return
            val = (val << 1) | node.val
            if node.left == None and node.right == None:
                num += val
                return
            preorder(node.left, val)
            preorder(node.right, val)
        preorder(root, 0)
        return num