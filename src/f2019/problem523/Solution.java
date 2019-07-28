package f2019.problem523;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        Map<Integer, Integer> reminderMap = new HashMap<>();
        reminderMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (k != 0) sum = sum % k;

            if (reminderMap.containsKey(sum)) {
                int index = reminderMap.get(sum);
                if (i - index > 0) return true;
            }

            reminderMap.put(sum, reminderMap.getOrDefault(sum, i));
        }
        return false;
    }
}