package f2019.problem10;

class Solution {
    boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        // For i = -1
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                setDp(-1, j, getDp(-1, j-2));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) setDp(i,j,getDp(i-1, j-1));
                else if (p.charAt(j) == '.') setDp(i,j, getDp(i-1, j-1));
                else if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j-1) && p.charAt(j-1) != '.') {
                        setDp(i,j,getDp(i, j-2));
                    } else {
                        setDp(i,j, getDp(i,j-1)||getDp(i-1,j)||getDp(i,j-2));
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private void setDp(int i, int j, boolean value) {
        dp[i+1][j+1] = value;
    }

    private boolean getDp(int i, int j) {
        return dp[i+1][j+1];
    }
}