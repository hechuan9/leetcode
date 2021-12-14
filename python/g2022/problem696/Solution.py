class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        curr = ''
        prev_group = 0
        curr_group = 0
        count = 0
        for c in s:
            if curr != c:
                count += min(prev_group, curr_group)
                prev_group = curr_group
                curr_group = 1
                curr = c
            else:
                curr_group += 1
        count += min(prev_group, curr_group)
        return count