package problem53;

class Solution {
    public int maxSubArray(int[] nums) {
        int ret = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ret = Math.max(sum, ret);
        }
        return ret;
    }
}