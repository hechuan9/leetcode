class Solution:
    def checkRecord(self, s: str) -> bool:
        aTotal = 0
        lTotal = 0
        lCurr = 0
        for c in s:
            if c == 'A':
                aTotal += 1
            
            if c == 'L':
                lCurr += 1
                lTotal = max(lTotal, lCurr)
            else:
                lCurr = 0
        return aTotal < 2 and lTotal < 3