package g2018.problem200;

import java.util.HashSet;
import java.util.Set;

class Solution {
    private int[] parents;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        parents = new int[m*n];
        for (int i = 0; i < m*n; i++) parents[i] = i;

        for (int i = 0; i < m*n; i++) {
            int row = i / n;
            int col = i % n;
            if (grid[row][col] == '0') {
                parents[i] = -1;
                continue;
            }
            if (row >= 1 && grid[row-1][col] == '1') union(i, i-m);
            if (col >= 1 && grid[row][col-1] == '1') union(i, i-1);
        }

        // for (int i = 0; i < m*n + 1; i++) System.out.println(parents[i]);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m*n; i++) {
            if (parents[i] != -1) {
                set.add(parent(i));
            }
        }

        return set.size() - 1;
    }

    private int parent(int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return i;
    }

    private void union(int i, int j) {
        parents[i] = j;
    }

}