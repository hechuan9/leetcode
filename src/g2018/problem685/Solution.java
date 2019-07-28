package g2018.problem685;

public class Solution {
    private int[] parents;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] edgeA = {-1, -1};
        int[] edgeB = {-1, -1};
        int[] directParents = new int[edges.length + 1];
        for (int[] edge : edges) {
            if (directParents[edge[1]] == 0) {
                directParents[edge[1]] = edge[0];
            } else {
                edgeA = new int[]{edge[0], edge[1]};
                edgeB = new int[]{directParents[edge[1]], edge[1]};
                edge[0] = 0;
            }
        }

        if (edgeA[0] == -1) {
            return unionFind(edges);
        } else {
            int[] edgeToRemove = unionFind(edges);
            return edgeToRemove == null ? edgeA : edgeB;
        }
    }

    private int[] unionFind(int[][] edges) {
        parents = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (edge[0] == 0) continue;
            if (parent(edge[0]) == parent(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return null;
    }

    private int parent(int node) {
        while(parents[node] != node) {
            parents[node] = parents[parents[node]];
            node = parents[node];
        }
        return node;
    }

    private void union(int a, int b) {
        parents[parent(a)] = parent(b);
    }
}
