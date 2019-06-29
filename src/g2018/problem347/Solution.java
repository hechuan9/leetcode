package g2018.problem347;


import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }

        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ret.add(pq.poll().getKey());
        }
        return ret;
    }
}
