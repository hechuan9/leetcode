package f2019.problem304;

class NumMatrix {

    int[][] areas;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m == 0 || n == 0) return;
        areas = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int area = matrix[i][j];
                if (i > 0 && j > 0) area -= areas[i-1][j-1];
                if (i > 0) area += areas[i-1][j];
                if (j > 0) area += areas[i][j-1];
                areas[i][j] = area;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int area = areas[row2][col2];
        if (row1 > 1) area -= areas[row1-1][col2];
        if (col1 > 1) area -= areas[row2][col1-1];
        if (row1 > 1 && col1 > 1) area += areas[row1-1][col1-1];
        return area;
    }
}