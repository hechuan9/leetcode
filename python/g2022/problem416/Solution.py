class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        @lru_cache(maxsize=None)
        def dfs(nums, i, target):
            if target == 0:
                return True
            if i == len(nums) or target < 0:
                return False
            return dfs(nums, i + 1, target) or dfs(nums, i + 1, target - nums[i])

        nums_sum = sum(nums)
        if nums_sum % 2 == 1:
            return False
        return dfs(tuple(nums), 0, nums_sum // 2)
