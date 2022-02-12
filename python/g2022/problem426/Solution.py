"""
# Definition for a Node.
class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def treeToDoublyList(self, root: 'Optional[Node]') -> 'Optional[Node]':
        first = None
        last = None
        
        def inorder(node):            
            if node == None:
                return
            
            nonlocal first
            nonlocal last
            inorder(node.left)
            node_right = node.right
            if last:
                last.right = node
                node.left = last
            else:
                first = node
            last = node
            inorder(node.right)
            
        if not root:
            return None
        inorder(root)
        first.left = last
        last.right = first
        return first
