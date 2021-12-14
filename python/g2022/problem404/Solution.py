# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        ret = 0

        def preorder(node, isLeft):
            if not node: return
            nonlocal ret
            if (node.left == None and node.right == None and isLeft):
                ret += node.val
                return
            preorder(node.left, True)
            preorder(node.right, False)

        preorder(root, False)
        return ret