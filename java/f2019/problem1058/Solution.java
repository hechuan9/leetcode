package f2019.problem1058;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public String minimizeError(String[] prices, int target) {
        double res = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();

        for (String _price : prices) {
            double price = Double.parseDouble(_price);
            int floor = (int)Math.floor(price);
            int ceil = (int)Math.ceil(price);
            res += price - floor;
            target -= floor;
            if (floor != ceil) {
                pq.add(ceil-price-price+floor);
            }

        }

        if (target < 0 || target > pq.size()) return Integer.toString(-1);

        while (target-- > 0) {
            res += pq.poll();
        }

        return String.format("%.3f", res);
    }
}