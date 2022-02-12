from functools import lru_cache

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        @lru_cache(maxsize=None)
        def lcs(p1, p2):
            if p1 == len(text1) or p2 == len(text2): #gone through every character
                return 0
            if text1[p1] == text2[p2]:
                return 1 + lcs(p1 + 1, p2 + 1)
            else:
                return max(lcs(p1, p2 + 1), lcs(p1 + 1, p2))
        return lcs(0,0)