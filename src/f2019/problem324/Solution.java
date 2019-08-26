package f2019.problem324;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res[] = new int[n];

        int lastEven = n % 2 == 0 ? n - 2 : n - 1;
        int lastOdd = n % 2 == 0 ? n - 1 : n - 2;
        for (int i = 0; i < (n | 1) / 2; i++) {
            res[lastEven-2*i] = nums[i];
        }

        for (int i = 0; i < n / 2; i++) {
            res[lastOdd-2*i] = nums[(n+1)/2+i];
        }

        if (n % 2 == 1) res[0] = nums[n/2];

        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}