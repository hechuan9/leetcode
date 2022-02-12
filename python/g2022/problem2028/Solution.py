class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        missingSum = mean * (n + m) - sum(rolls)

        if missingSum < n or missingSum > n * 6:
            return []

        part, rem = divmod(missingSum, n)
        ret = [part] * n
        for i in range(rem):
            ret[i] += 1
        return ret