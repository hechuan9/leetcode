package g2018.problem454;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i] + b[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int sum = -(c[i] + d[j]);
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}