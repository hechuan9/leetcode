package f2019.problem91;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') dp[i] = dp[i-1];
            int value = Integer.valueOf(s.substring(i-2, i));
            if (value <= 26 && value >= 10) dp[i] += dp[i-2];
        }

        return dp[n];

    }
}