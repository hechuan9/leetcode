package f2019.problem1057;

import java.util.*;

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                List<int[]> list = map.getOrDefault(distance, new LinkedList<>());
                list.add(new int[] {i, j});
                map.put(distance, list);
            }
        }

        Set<Integer> assignedWorkers = new HashSet<>();
        Set<Integer> assignedBikes = new HashSet<>();
        int[] res = new int[workers.length];

        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            for (int[] pair : entry.getValue()) {
                if (assignedWorkers.contains(pair[0])) continue;
                if (assignedBikes.contains(pair[1])) continue;
                res[pair[0]] = pair[1];
                assignedWorkers.add(pair[0]);
                assignedBikes.add(pair[1]);
            }
        }
        return res;
    }
}