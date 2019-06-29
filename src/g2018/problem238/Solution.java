package problem238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i=1; i<output.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int right = 1;
        for (int i=output.length-2; i>=0; i--) {
            right *= nums[i+1];
            output[i] *= right;
        }
        return output;
    }
}