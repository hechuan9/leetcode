package problem118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows >= 1) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            triangle.add(row);
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prevRow = triangle.get(i-1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                row.add(prevRow.get(j) + prevRow.get(j+1));
            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }
}