package problem210;

import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adj = new ArrayList<>(); // Adjacent List
        int[] inCount = new int[numCourses]; // List to count number of incoming edges
        for (int i = 0; i < numCourses; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
            inCount[edge[0]]++;
        }
        Queue<Integer> workQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inCount[i] == 0) {
                workQueue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int count = 0;
        while (!workQueue.isEmpty()) {
            Integer from = workQueue.poll();
            order[count++] = from;
            for (Integer to : adj.get(from)) {
                if (--inCount[to] == 0) {
                    workQueue.offer(to);
                }
            }
        }

        return count == numCourses ? order : new int[0];
    }
}
