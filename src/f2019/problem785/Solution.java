package f2019.problem785;

import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < visited.length; i++) visited[i] = 0;

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 1) continue;

            Set<Integer> queue = new HashSet<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                Set<Integer> nextQueue = new HashSet<>();

                for (Integer node : queue) {
                    visited[node] = 1;
                    for (int nextNode : graph[node]) {
                        if (queue.contains(nextNode)) return false;
                        if (visited[nextNode] == 0) {
                            nextQueue.add(nextNode);
                        }
                    }
                }

                queue = nextQueue;
            }
        }


        return true;
    }
}