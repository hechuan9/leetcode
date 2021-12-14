# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def count(node):
            if (node == None):
                return 0
            return 1 + count(node.next)

        def locate(node, count):
            if count == 0:
                return node
            return locate(node.next, count - 1)

        count = count(head)
        return locate(head, count//2)
