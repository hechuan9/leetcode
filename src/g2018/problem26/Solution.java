package problem26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int prev = nums[0];
        int working = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[working] = nums[i];
            if (prev != nums[i]) {
                prev = nums[i];
                working++;
            }
        }
        return working;
    }
}