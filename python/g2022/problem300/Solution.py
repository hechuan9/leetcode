class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1]
        globalMax = 1
        for i in range(1, len(nums)):
            localMax = 1
            for j in range(0, i):
                if nums[i] > nums[j]:
                    localMax = max(localMax, dp[j] + 1)
            globalMax = max(localMax, globalMax)
            dp.append(localMax)
        return globalMax
        