package f2019.problem311;

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int o = B[0].length;

        int[][] output = new int[m][o];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;
                for (int k = 0; k < o; k++) {
                    if (B[j][k] == 0) continue;
                    output[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return output;

    }
}