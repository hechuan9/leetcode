class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1:
            return 0
        profit = 0
        minP = prices[0]
        for i in range(1, len(prices)):
            if prices[i] < prices[i-1]:
                profit += max(0, prices[i-1] - minP)
                minP = prices[i]

        profit += max(0, prices[-1] - minP)
        return profit