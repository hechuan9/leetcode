package problem5;

class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ret = "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && (j-i+1) > max) {
                    max = j - i + 1;
                    ret = s.substring(i, j+1);
                }
            }
        }
        return ret;
    }
}