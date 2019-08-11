package f2019.problem238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (n <= 1) return nums;

        int[] prod = new int[n];
        int[] output = new int[n];
        prod[n-1] = nums[n-1];
        for (int i = n - 2; i>=0; i--) {
            prod[i] = nums[i] * prod[i+1];
        }

        int product = 1;
        for (int i = 0; i < n - 1; i++) {
            prod[i] = product * prod[i+1];
            product *= nums[i];
        }
        prod[n-1] = product;

        return prod;
    }
}