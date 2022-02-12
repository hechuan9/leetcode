class Solution:
    def validPalindrome(self, s: str) -> bool:
        start = 0
        end = len(s) - 1
        while (start < end):
            if s[start] != s[end]:
                one, two = s[start:end], s[start + 1:end + 1]
                return one == one[::-1] or two == two[::-1]
            start, end = start + 1, end - 1
        return True