package context.problem5053;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i,j});
                    visited[i][j] = 1;
                }
            }
        }

        int res = -1;
        int[][] dirs = new int[][] {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            Queue<int[]> nextQueue = new LinkedList<>();
            for (int[] point : queue) {
                res = Math.max(res, grid[point[0]][point[1]] - 1);

                for (int[] dir : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y] != 1) {
                        grid[x][y] = grid[point[0]][point[1]] + 1;
                        nextQueue.add(new int[] {x, y});
                        visited[x][y] = 1;
                    }
                }
            }
            queue = nextQueue;
        }

        return res  == 0 ? -1 : res;
    }
}