class Solution:
    def maxPower(self, s: str) -> int:
        if s == '':
            return 0
        prev = s[0]
        count = 1
        ret = 1
        for c in s[1:]:
            if prev == c:
                count += 1
            else:
                count = 1
            prev = c
            ret = max(ret, count)

        return ret
