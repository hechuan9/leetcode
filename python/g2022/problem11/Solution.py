class Solution:
    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height) - 1
        ret = 0
        while (i < j):
            vol = min(height[i], height[j]) * (j - i)
            ret = max(ret, vol)
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return ret
