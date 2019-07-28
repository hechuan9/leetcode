package f2019.problem5;

class Solution {
    private String res = "";

    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }
        return res;
    }

    private void helper(String s, int i, int j) {
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }
        if (j - i - 1 > res.length()) res = s.substring(i+1, j);
    }
}