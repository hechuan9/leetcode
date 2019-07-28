package g2018.problem684;

public class Solution {
    private int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1; // Because we start from 1
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            if (parent(edge[0]) == parent(edge[1])) { // Same parent without union means they have redundant
                return edge;
            }
            union(edge[0], edge[1]);
        }

        return new int[0];
    }

    private int parent(int node) {
        while (parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    // Not correct
    private void union(int a, int b) {
        parents[a] = b;
    }
}
