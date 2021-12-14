class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        num_set = set()
        for num in nums:
            if num in num_set:
                num_set.remove(num)
            else:
                num_set.add(num)
        return num_set