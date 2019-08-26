package airbnb;

public class CheapestFlightsDP {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            long[][] prices = new long[k+2][n];
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < n; j++) {
                    prices[i][j] = Integer.MAX_VALUE;
                }
            }

            prices[0][src] = 0;
            for (int i = 1; i < k+2; i++) {
                prices[i][src] = 0;
                for (int[] flight : flights) {
                    int start = flight[0];
                    int end = flight[1];
                    int price = flight[2];
                    prices[i][end] = Math.min(prices[i][end], prices[i-1][start] + price);
                }
            }

            return prices[k+1][dst] == Integer.MAX_VALUE ? -1 : (int)prices[k+1][dst];
        }
    }