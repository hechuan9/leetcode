class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        minP = float('inf')
        for price in prices:
            minP = min(minP, price)
            profit = max(profit, price - minP)
        return profit