package problem122;

class Solution {
    public int maxProfit(int[] prices) {
        int prev = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prev) {
                if (max != 0) {
                    profit += max - min;
                    max = 0;
                }
                min = prices[i];
            } else if (prices[i] > prev) {
                max = prices[i];
            }
            prev = prices[i];
        }
        if (max != 0) profit += max - min;
        return profit;
    }
}