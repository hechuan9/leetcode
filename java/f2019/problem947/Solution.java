package f2019.problem947;

import java.util.HashSet;
import java.util.Set;

class Solution {
    class DSU {
        int[] parents;

        public DSU(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        private int parent(int i) {
            while (parents[i] != i) {
                i = parents[i];
            }
            return i;
        }

        public void union(int i, int j) {
            parents[parent(i)] = parent(j);
        }
    }

    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(20000);
        for (int i = 0; i < stones.length; i++) {
            dsu.union(stones[i][0], stones[i][1]+10000);
        }

        Set<Integer> groups = new HashSet();
        for (int i = 0; i < stones.length; i++) {
            groups.add(dsu.parent(stones[i][0]));
    }

        return stones.length - groups.size();
    }

}