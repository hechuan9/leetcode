# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        range_sum = 0
        def preorder(node, low, high):
            if node == None:
                return

            if node.val < low: # can go right, no need to go left
                preorder(node.right, low, high)
            elif node.val > high:  # can go left, no need to go right
                preorder(node.left, low, high)
            else:
                nonlocal range_sum
                range_sum += node.val
                preorder(node.left, low, high)
                preorder(node.right, low, high)

        preorder(root, low, high)
        return range_sum