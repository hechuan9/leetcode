class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if n == 1:
            return nums

        i = n - 2
        while i >= 0 and nums[i] >= nums[i+1]:
            i -= 1

        # print(i)
        if i > -1:
            j = n - 1
            while j > i and nums[j] <= nums[i]:
                j -= 1
            nums[j], nums[i] = nums[i], nums[j]
        # swap
        left, right = i + 1, n - 1
        print(left,right)
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
