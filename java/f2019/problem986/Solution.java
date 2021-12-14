package f2019.problem986;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> res = new LinkedList<>();

        int m = a.length;
        int n = b.length;

        int i = 0;
        int j = 0;
        while (i != m && j != n) {
            int startMax = Math.max(a[i][0], b[j][0]);
            int endMin = Math.min(a[i][1], b[j][1]);
            if (endMin >= startMax) res.add(new int[]{startMax, endMin});

            if (a[i][1] == endMin) i++;
            if (b[j][1] == endMin) j++;
        }

        return res.stream().toArray(int[][] :: new);
    }
}