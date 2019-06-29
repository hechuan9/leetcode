package problem152;

class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i]*max, nums[i]);
            min = Math.min(nums[i]*min, nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}