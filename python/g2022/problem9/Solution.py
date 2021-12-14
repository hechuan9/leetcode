class Solution:
    def isPalindrome(self, _x: int) -> bool:
        x = _x
        if (x < 0): return False
        ret = 0
        while (x != 0):
            ret = ret * 10 + x % 10
            x //= 10
        return ret == _x