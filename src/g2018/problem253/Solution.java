package g2018.problem253;

import support.Interval;

import java.util.Arrays;

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }
}