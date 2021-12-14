class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key=itemgetter(0))
        h = []
        heapq.heappush(h, intervals[0][1])

        for interval in intervals[1:]:
            if h[0] <= interval[0]:
                heapq.heappop(h)
            heapq.heappush(h, interval[1])

        return len(h)
