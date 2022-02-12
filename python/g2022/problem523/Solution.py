class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        prefix_sum = {}
        # The case for all items
        prefix_sum[0] = -1
        curr_sum = 0
        for i in range(len(nums)):
            curr_sum += nums[i]       
            if curr_sum % k in prefix_sum:
                if i - prefix_sum[curr_sum % k] >= 2:
                    return True
            else:
                prefix_sum[curr_sum % k] = i
        return False