class Solution:
    def arrangeCoins(self, n: int) -> int:
#         def arrangeCoin(level, left) -> int:
#             if (left == level): return level
#             if (left < level): return level - 1
#             return arrangeCoin(level + 1, left - level)

#         return arrangeCoin(1, n)

        left, right = 0, n
        while (left <= right):
            mid = (left + right) // 2
            value = mid * (mid + 1) // 2
            if (value == n): return mid
            if (value > n): right = mid - 1
            if (value < n): left = mid + 1
        return right
