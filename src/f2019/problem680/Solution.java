package f2019.problem680;

class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false, 0, s.length() - 1);
    }

    private boolean validPalindrome(String s, boolean deleted, int i, int j) {
        if (j - i <= 0) return true;
        if (s.charAt(i) != s.charAt(j)) {
            if (deleted) return false;
            else {
                return validPalindrome(s, true, i, j - 1) ||
                        validPalindrome(s, true, i + 1, j);
            }
        }
        return validPalindrome(s, deleted, i + 1, j - 1);
    }
}