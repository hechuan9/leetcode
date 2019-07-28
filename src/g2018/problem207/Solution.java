package g2018.problem207;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> adj = new ArrayList<>();
        int[] incount = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
            incount[pair[0]]++;
        }

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (incount[i] == 0) {
                stack.add(i);
                count++;
            }
        }

        while (!stack.isEmpty()) {
            int from = stack.pop();
            for (Integer child : adj.get(from)) {
                //children.remove(child);
                incount[child]--;
                if (incount[child] == 0) {
                    stack.add(child);
                    count++;
                }
            }

        }

        return count == numCourses;
    }
}