package g2018.problem75;

class Solution {
    public void sortColors(int[] nums) {
        int red = -1;
        int blue = nums.length;
        for (int i = 0; i < blue; i++) {
            if (nums[i] == 0) swap(nums, i, ++red);
            else if (nums[i] == 2) swap(nums, i--, --blue);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}