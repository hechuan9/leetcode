package problem56;

import support.Interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.start));
        for (Interval interval : intervals) {
            pq.offer(interval);
        }
        List<Interval> ret = new LinkedList<>();
        while(!pq.isEmpty()) {
            Interval int1 = pq.poll();
            if (pq.isEmpty()) {
                ret.add(int1);
                break;
            }
            Interval int2 = pq.poll();
            if (mergeable(int1, int2)) {
                pq.offer(getMerged(int1, int2));
            } else {
                ret.add(int1);
                pq.offer(int2);
            }
        }
        return ret;
    }

    private boolean mergeable(Interval int1, Interval int2) {
        return int1.end >= int2.start;
    }

    private Interval getMerged(Interval int1, Interval int2) {
        return new Interval(Math.min(int1.start, int2.start), Math.max(int1.end, int2.end));
    }
}