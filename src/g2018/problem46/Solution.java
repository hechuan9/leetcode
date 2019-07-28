package g2018.problem46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> prev, int[] nums) {
        if (prev.size() == nums.length) {
            res.add(new ArrayList<>(prev));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (prev.contains(nums[i])) continue;
            prev.add(nums[i]);
            helper(res, prev, nums);
            prev.remove(prev.size() - 1);
        }
    }

}