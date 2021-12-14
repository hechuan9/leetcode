package g2018.problem78;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        int musk = 0;
        while (musk != Math.pow(2, nums.length)) {
            int curMusk = musk;
            List<Integer> curList = new LinkedList<>();
            int index = 0;
            while (curMusk != 0) {
                if (curMusk % 2 == 1) curList.add(nums[index]);
                index++;
                curMusk /= 2;
            }
            res.add(curList);
            musk++;
        }
        return res;
    }
}