package g2018.problem91;

// Watch https://www.youtube.com/watch?v=yKQnqmb9wiU For more explanation
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if (first > 0) {
                dp[i] += dp[i-1];
            }
            if (second <= 26 && second >= 10) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}