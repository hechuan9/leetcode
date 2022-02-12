class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        fast = head
        slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if fast == slow:
                break
        
        if fast == None or fast.next == None:
            return None
        
        tracker = head
        while tracker != slow:
            tracker = tracker.next
            slow = slow.next
        return slow
        