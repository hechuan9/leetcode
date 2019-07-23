package f2019.problem75;

class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = 0;
        while (i <= blue) {
            if (nums[i] == 0) {
                swap(nums,i,red);
                i++; red++;
            } else if (nums[i] == 2) {
                swap(nums,i,blue);
                blue--;
            } else {
                i++;
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}