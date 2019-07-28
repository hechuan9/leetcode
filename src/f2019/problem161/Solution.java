package f2019.problem161;

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m == 0 && n == 0) return false;
        if (Math.abs(m - n) > 1) return false;

        boolean insertPossible = m < n;
        boolean deletePossible = m > n;
        boolean replacePossible = m == n;

        int i = 0;
        int j = 0;

        while(i < m && j < n) {
            if (s.charAt(i) != t.charAt(j)) {
                if (insertPossible) {
                    j++;
                    insertPossible = false;
                } else if (deletePossible) {
                    i++;
                    deletePossible = false;
                } else if (replacePossible) {
                    i++; j++;
                    replacePossible = false;
                } else {
                    return false;
                }
            } else {
                i++;
                j++;
            }

        }

        if (i < m) return deletePossible;
        if (j < n) return insertPossible;
        return !replacePossible;
    }
}