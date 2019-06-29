package problem215;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else {
                int old = pq.poll();
                pq.offer((nums[i] > old ? nums[i] : old));
            }
        }
        return pq.poll();
    }
}