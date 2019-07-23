package f2019.problem34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int first = findFirst(nums, target);
        if (first == -1) return new int[]{-1, -1};
        int last = findLast(nums, target);
        return new int[]{first, last};

    }

    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (left == nums.length || nums[left] != target) ? -1 : left;

    }

    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;

    }
}