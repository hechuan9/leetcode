package f2019.problem317;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;
        int[][] distances = new int[m][n];
        int[][] reach = new int[m][n];
        int buildingNum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    grid[i][j] = 0;
                    // BFS
                    Queue<int[]> queue = new LinkedList<>();
                    int[][] visited = new int[m][n];
                    queue.offer(new int[] {i,j});
                    int distance = 0;

                    while (!queue.isEmpty()) {
                        Queue<int[]> nextQueue = new LinkedList<>();
                        for (int[] land : queue) {
                            int row = land[0];
                            int col = land[1];

                            if (row < 0 || row >= m || col < 0 || col >= n) continue;
                            if (grid[row][col] != 0) continue;
                            if (visited[row][col] == 1) continue;
                            visited[row][col] = 1;

                            distances[row][col] += distance;
                            reach[row][col]++;

                            nextQueue.add(new int[]{row-1, col});
                            nextQueue.add(new int[]{row+1, col});
                            nextQueue.add(new int[]{row, col-1});
                            nextQueue.add(new int[]{row, col+1});
                        }

                        queue = nextQueue;
                        distance++;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    res = Math.min(res, distances[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}