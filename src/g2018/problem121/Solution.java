package g2018.problem121;

class Solution {
    public int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        int profitRecord = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[min]) {
                min = i;
                max = i;
            }
            if (prices[i] > prices[max]) {
                max = i;
            }
            profitRecord = Math.max(profitRecord, prices[max] - prices[min]);
        }
        return profitRecord;
    }
}