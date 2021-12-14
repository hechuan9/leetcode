package f2019.problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> sol) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(sol));
        }
        while (i < candidates.length) {
            if (candidates[i] > target) break;
            sol.add(candidates[i]);
            helper(candidates, target - candidates[i], i, sol);
            sol.remove(sol.size()-1);
            i++;
        }
    }
}