package context.problem1140;

import java.util.HashMap;
import java.util.Map;

class Solution {
    class Tuple {
        int i;
        int m;

        Tuple(int i , int m) {
            this.i = i;
            this.m = m;
        }
    }

    private Map<Tuple, Integer> map;
    public int stoneGameII(int[] piles) {
        map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        int score = score(piles, 0, 1);

        return (sum + score) / 2;
    }

    private int score(int[] piles, int i, int m) {
        Integer score = map.get(new Tuple(i, m));
        if (score != null) return score;

        int max = 0;
        int pilesGot = 0;
        for (int x = 1; x <= 2 * m; x++) {
            int end = i + x - 1;
            if (end >= piles.length) break;

            pilesGot += piles[end];
            max = Math.max(max, pilesGot - score(piles, i + x, Math.max(m, x)));
        }
        map.put(new Tuple(i, m), max);
        return max;
    }


}