package f2019.problem15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    while(low < high && nums[low+1] == nums[low]) low++;
                    while(low < high && nums[high-1] == nums[high]) high--;
                    ret.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return ret;
    }
}