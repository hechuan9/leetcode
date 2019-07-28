package f2019.problem33;


class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int low = left;
        if (target == nums[low]) return low;
        if (target <= nums[n-1]) {
            left = low;
            right = n - 1;
        } else {
            left = 0;
            right = low - 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return  -1;
    }
}