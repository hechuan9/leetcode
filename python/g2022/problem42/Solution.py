class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n <= 2:
            return 0

        left = [0] * n
        right = [0] * n

        right[0] = height[0]
        left[n-1] = height[n-1]
        for i in range(1,n):
            right[i] = max(height[i], right[i-1])
        for i in reversed(range(0,n-1)):
            left[i] = max(height[i], left[i+1])
        # print(left)
        # print(right)

        sum = 0
        for i in range(1,n-1):
            sum += min(left[i], right[i]) - height[i]
        return sum