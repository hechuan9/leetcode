# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(-1)
        dummy.next = head
        node = dummy
        count = -1

        def findAndDeleteNode(node, n):
            if (node == None):
                return 0
            count = findAndDeleteNode(node.next, n) + 1
            if count == n+1:
                node.next = node.next.next
            return count

        findAndDeleteNode(dummy, n)
        return dummy.next
