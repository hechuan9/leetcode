package f2019.problem973;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> -e1[0]*e1[0]-e1[1]*e1[1]+e2[0]*e2[0]+e2[1]*e2[1]);
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }

        return pq.stream().toArray(int[][] :: new);
    }
}