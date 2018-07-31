package problem204;

import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] array = new boolean[n];
        Arrays.fill(array, true);
        array[1] = array[0] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (array[i] == false) continue;
            for (int j = i*i; j < n; j += i) {
                array[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (array[i]) count++;
        }
        return count;
    }
}