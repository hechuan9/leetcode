package f2019.problem621;

import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char task : tasks) {
            count[task-'A']++;
        }
        Arrays.sort(count);

        int cycles = 0;
        while (count[25] != 0) {
            for (int i = 0; i <= n; i++) {
                if (count[25] == 0) break;
                if (i < 26 && count[25 - i] > 0) count[25 - i]--;
                cycles++;
            }
            Arrays.sort(count);
        }

        return cycles;
    }
}