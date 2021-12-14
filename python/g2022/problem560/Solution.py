class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        cache = defaultdict(int)
        total = 0
        count = 0
        for num in nums:
            total = total + num
            if total == k: count += 1
            if cache[total-k]: count += cache[total-k]
            cache[total] += 1
        return count
