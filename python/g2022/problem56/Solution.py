class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals = sorted(intervals, key=itemgetter(0))
        start, end = intervals[0]
        ret = []

        for interval in intervals[1:]:
            if interval[0] <= end:
                end = max(end, interval[1])
            else:
                ret.append([start, end])
                start = interval[0]
                end = interval[1]
        ret.append([start, end])
        return ret
