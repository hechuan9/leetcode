package f2019.problem935;

class Solution {
    public int knightDialer(int n) {
        if (n == 0) return 0;
        int[][] table = new int[][] {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int[] nums = new int[] {1,1,1,1,1,1,1,1,1,1};
        int mod = (int)1e9+7;

        for (int i = 2; i <= n; i++) {
            int[] next = new int[10];
            for (int j = 0; j <= 9; j++) {
                for (int nextV : table[j]) {
                    next[nextV] += nums[j];
                    next[nextV] %= mod;
                }
            }
            nums = next;
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += nums[i];
            sum = sum % mod;
        }
        return sum;
    }
}