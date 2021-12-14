package f2019.problem252;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;

        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]) return false;
        }

        return true;
    }
}