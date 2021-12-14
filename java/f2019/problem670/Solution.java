package f2019.problem670;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maximumSwap(int num) {
        String temp = Integer.toString(num);
        int n = temp.length();
        int[] bucket = new int[10];
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            int digit = temp.charAt(i) - '0';
            bucket[digit] = i;
            digits[i] = digit;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 9; j > digits[i]; j--) {
                if (bucket[j] > i) {
                    int swap = digits[bucket[j]];
                    digits[bucket[j]] = digits[i];
                    digits[i] = swap;
                    int res = 0;
                    for (Integer integer : digits) {
                        res *= 10;
                        res += integer;
                    }
                    return res;
                }
            }
        }
        return num;

    }
}