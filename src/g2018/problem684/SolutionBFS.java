package g2018.problem684;

import java.util.*;

public class SolutionBFS {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        List<Set<Integer>> adj = new ArrayList<>();
        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            connections.add(convertIntArrayToList(edge));
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (!leaves.isEmpty()) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                int next = adj.get(leave).iterator().next();
                adj.get(leave).remove(next);
                adj.get(next).remove(leave);
                connections.remove(Arrays.asList(Math.min(leave, next), Math.max(leave, next)));
                if (adj.get(next).size() == 1) {
                    newLeaves.add(next);
                }
            }
            leaves = newLeaves;
        }

        return connections.get(connections.size() - 1).stream().mapToInt(i->i).toArray();
    }

    private List<Integer> convertIntArrayToList(int[] input) {

        List<Integer> list = new ArrayList<>();
        for (int i : input) {
            list.add(i);
        }
        return list;

    }
}
