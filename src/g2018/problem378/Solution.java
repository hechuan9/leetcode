package problem378;

import java.util.PriorityQueue;

class Solution {
    class Tuple implements Comparable<Tuple> {
        int val, x, y;
        Tuple(int[][] matrix, int x, int y) {
            this.x = x;
            this.y = y;
            this.val = matrix[x][y];
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Tuple(matrix, 0, i));
        }
        int count = 0;
        for (int i = 1; i < k; i++) {
            Tuple tuple = pq.poll();
            if (tuple.x == n - 1) continue; // last row
            pq.offer(new Tuple(matrix, tuple.x+1, tuple.y));
        }
        return pq.poll().val;
    }
}