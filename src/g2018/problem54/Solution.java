package g2018.problem54;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();

        if (matrix.length == 0) return res;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            for (int i = rowBegin + 1; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            if (rowBegin != rowEnd) {
                for (int i = colEnd - 1; i >= colBegin; i--) {
                    res.add(matrix[rowEnd][i]);
                }
            }
            if (colBegin != colEnd) {
                for (int i = rowEnd - 1; i >= rowBegin + 1; i--) {
                    res.add(matrix[i][colBegin]);
                }
            }

            rowBegin++;
            rowEnd--;
            colBegin++;
            colEnd--;
        }
        return res;
    }
}