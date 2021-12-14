class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        n = len(nums)
        prefix_sums = {0:-1}
        prefix_sum = 0
        max_length = 0
        for i in range(n):
            prefix_sum += nums[i]
            if prefix_sum - k in prefix_sums:
                max_length = max(max_length, i - prefix_sums[prefix_sum - k])

            if prefix_sum not in prefix_sums: # We want this to be a small as possible
                prefix_sums[prefix_sum] = i


        return max_length
