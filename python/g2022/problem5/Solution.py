class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ret = []
        nums.sort()
        n = len(nums)
        i = 0
        while i <= n-2:
            start = i + 1
            end = n - 1
            while(start < end):
                if nums[start] + nums[end] == -nums[i]:
                    ret.append([nums[i], nums[start], nums[end]])
                    while start < end and nums[start] == nums[start+1]:
                        start += 1
                    while start < end and nums[end] == nums[end-1]:
                        end -= 1
                    start += 1
                    end -= 1
                elif nums[start] + nums[end] < -nums[i]:
                    start += 1
                else: # >
                    end -= 1
            while (i <= (n-2) and nums[i+1] == nums[i]):
                i += 1
            i = i + 1
        return ret