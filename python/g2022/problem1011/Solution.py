class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        low, high = max(weights), sum(weights)
        while (low < high):
            mid = (low + high) // 2
            need = 1
            curr = 0
            for weight in weights:
                if (curr + weight) > mid:
                    need += 1
                    curr = 0
                curr += weight
            if (need <= days):
                high = mid
            else:
                low = mid + 1
        return low