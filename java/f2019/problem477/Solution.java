package f2019.problem477;

class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int oneCount = 0;
            for (int j = 0; j < n; j++) {
                oneCount += nums[j] & 1;
                nums[j] = nums[j] >> 1;
            }
            total += oneCount * (n - oneCount);
        }
        return total;
    }
}
