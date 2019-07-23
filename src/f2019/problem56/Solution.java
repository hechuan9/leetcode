package f2019.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
        List<int[]> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < intervals.length) {
            int end = intervals[i][1];
            while (j < intervals.length && intervals[j][0] <= end) {
                end = Math.max(intervals[j][1], end);
                j++;
            }
            res.add(new int[]{intervals[i][0], end});
            i = j;
        }

        return res.stream().toArray(int[][] :: new);
    }
}