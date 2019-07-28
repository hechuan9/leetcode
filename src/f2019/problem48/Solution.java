package f2019.problem48;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n+1)/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                rotate(matrix, i, j, n);
            }
        }
    }

    private void rotate(int[][] matrix, int i, int j, int n) {
        int temp = matrix[n-j-1][i];
        matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
        matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
        matrix[j][n-i-1] = matrix[i][j];
        matrix[i][j] = temp;
    }
}