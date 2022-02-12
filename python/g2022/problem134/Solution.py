class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        bestIndex = -1
        curMin = sys.maxsize
        finalGas = 0
        n = len(gas)
        for i in range(n):
            # put in gas first
            finalGas += gas[i]
            # travel
            finalGas -= cost[i]
            if finalGas < curMin:
                curMin = finalGas
                bestIndex = (i + 1) % n
        return -1 if finalGas < 0  else bestIndex