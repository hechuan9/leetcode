package problem48;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = (n - 1) / 2;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m + i; j++) {
                int temp = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
