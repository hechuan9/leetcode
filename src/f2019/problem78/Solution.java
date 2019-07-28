package f2019.problem78;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        fill(nums, new LinkedList<>(), 0);
        return res;
    }

    private void fill(int[] nums, List<Integer> subset, int start) {
        if (start == nums.length) {
            res.add(new LinkedList<>(subset));
            return;
        }

        Integer num = nums[start];
        fill(nums, subset, start + 1);
        subset.add(num);
        fill(nums, subset, start + 1);
        subset.remove(num);
    }
}