# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        ret = 0

        def inorder(node, num):
            nonlocal ret
            if (node == None):
                return

            num *= 10
            num += node.val
            # Leave node
            if (node.left == None and node.right == None):
                ret += num

            inorder(node.left, num)
            inorder(node.right, num)

        inorder(root, 0)
        return ret