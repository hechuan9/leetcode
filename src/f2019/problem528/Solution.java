package f2019.problem528;

import java.util.Arrays;
import java.util.Random;

class Solution {
    Random random = new Random();
    int[] acc;
    int max;

    public Solution(int[] w) {
        acc = new int[w.length];
        acc[0] = w[0];
        max = w[0];

        for (int i = 1; i < w.length; i++) {
            acc[i] = acc[i-1] + w[i];
            max += w[i];
        }
    }

    public int pickIndex() {
        int accWeight = random.nextInt(max) + 1;
        int index = Arrays.binarySearch(acc, accWeight);
        if (index < 0) index = -index - 1;
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */