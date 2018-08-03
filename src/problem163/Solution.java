package problem163;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> res;

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        res = new LinkedList<>();

        if (n == 0) {
            long diff = (long)upper - lower;
            if (diff == 0) {
                res.add(lower + "");
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }

        generateDiff((long)nums[0] - lower + 1, lower - 1, nums[0]);
        for (int i = 1; i < n; i++) {
            generateDiff((long)nums[i] - nums[i-1], nums[i-1], nums[i]);
        }
        generateDiff((long)upper - nums[n-1] + 1, nums[n-1], upper + 1);

        return res;
    }

    private void generateDiff(long diff, int low, int high) {
        if (diff > 2) {
            res.add((low+1) + "->" + (high-1));
        } else if (diff == 2) {
            res.add((low+1) + "");
        }
    }
}