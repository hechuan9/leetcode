import heapq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        pq = [(-self.distance(points[i]), points[i]) for i in range(k)]
        heapq.heapify(pq)
        for point in points[k:]:
            dist = -self.distance(point)
            if dist > pq[0][0]:                
                heapq.heappushpop(pq, (dist, point))
        return [point for (_, point) in pq]
        
    def distance(self, point):
        return point[0] ** 2 + point[1] ** 2