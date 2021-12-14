package f2019.problem632;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.get(0)));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : nums) {
            pq.add(list);
            min = Math.min(list.get(0), min);
            max = Math.max(list.get(0), max);
        }

        int[] res = new int[]{min, max};
        int length = max - min;

        while (!pq.isEmpty()) {
            List<Integer> listWithSmallest = pq.poll();
            if (listWithSmallest.size() == 1) break;
            listWithSmallest.remove(0);
            max = Math.max(max, listWithSmallest.get(0));
            pq.add(listWithSmallest);

            if (max - min < length) {
                res = new int[]{min, max};
                length = max - min;
            }

        }
        return res;
    }
}