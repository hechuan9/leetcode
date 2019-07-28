package g2018.problem73;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n =  matrix[0].length;
        boolean[] rowToClear = new boolean[m];
        boolean[] colToClear = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]== 0) {
                    rowToClear[i] = true;
                    colToClear[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (rowToClear[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (colToClear[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}