class Solution:
    def minKnightMoves(self, x: int, y: int) -> int:
        dirs = [(1,2),(2,1),(-1,2),(-2,1),(1,-2),(2,-1),(-1,-2),(-2,-1)]
        queue = deque([(0,0)])
        visited = set((0,0))
        move = 0

        while queue:
            count = len(queue)
            for i in range(count):
                curr = queue.popleft()
                if curr[0] == x and curr[1] == y:
                    return move

                for dir in dirs:
                    next = (curr[0] + dir[0], curr[1] + dir[1])
                    if next not in visited:
                        visited.add(curr)
                        queue.append(next)
            move += 1
        return -1
