package f2019.problem118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows >= 1) res.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; i++) {
            List<Integer> lastRow = res.get(res.size() - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < lastRow.size() - 1; j++) {
                row.add(lastRow.get(j) + lastRow.get(j+1));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
