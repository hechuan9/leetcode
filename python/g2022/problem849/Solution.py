class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        n = len(seats)
        last = 0
        maxDistance = 0
        # middle position
        for curr in range(0, n):
            if seats[curr] == 1:                
                maxDistance = max(maxDistance, curr - last)
                last = curr
        maxDistance = maxDistance // 2
        for curr in range(0,n):
            if seats[curr] == 1:
                maxDistance = max(maxDistance, curr)
                break
        for curr in reversed(range(0,n)):
            if seats[curr] == 1:
                maxDistance = max(maxDistance, n - curr - 1)
                break
        return maxDistance
        
            
            