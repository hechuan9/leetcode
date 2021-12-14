class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1:
            return s

        lists = ['' for i in range(numRows)]
        i = 0
        row = 0
        step = 1 # -1 down, 1 up

        while i < len(s):
            lists[row] += s[i]
            row += step
            if row == 0 or row == numRows - 1:
                step = -step

            i += 1


        return ''.join(lists)
