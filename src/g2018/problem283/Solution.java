package problem283;

class Solution {
    public void moveZeroes(int[] nums) {
        int insertPosition = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPosition++] = num;
        }

        for (int i = insertPosition; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}