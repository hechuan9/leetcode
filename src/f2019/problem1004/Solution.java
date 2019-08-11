package f2019.problem1004;

class Solution {
    public int longestOnes(int[] a, int k) {
        int i = 0;
        int max = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] == 0) k--;
            while (k < 0) {
                if (a[i] == 0) k++;
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}