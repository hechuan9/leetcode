package problem279;

import java.util.LinkedList;
import java.util.List;

// Try bottom up
class Solution {
    private int[] memories;
    private List<Integer> perfects = new LinkedList<>();;

    public int numSquares(int n) {
        memories = new int[n+1];

        int i = 1;
        while (i*i <= n) {
            perfects.add(i*i);
            i++;
        }

        return helper(n);
    }

    private int helper(int n) {
        if (memories[n] != 0) return memories[n];

        int min = Integer.MAX_VALUE;
        for (int perfect : perfects) {
            if (perfect > n) continue;
            if (perfect == n) min = 0;
            else min = Math.min(min, helper(n-perfect));
        }
        memories[n] = min + 1;
        return memories[n];
    }
}