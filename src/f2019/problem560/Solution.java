package f2019.problem560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (preSum.containsKey(sum - k)) {
                total += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}