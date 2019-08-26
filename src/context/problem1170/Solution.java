package context.problem1170;

import java.util.Arrays;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qCount = new int[queries.length];
        int[] wCount = new int[words.length];

        for (int i = 0; i < queries.length; i++) {
            qCount[i] = f(queries[i]);
        }

        for (int j = 0; j < words.length; j++) {
            wCount[j] = f(words[j]);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (qCount[i] < wCount[j]) res[i]++;
            }
        }
        return res;
    }

    private int f(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) return counts[i];
        }
        return 0;
    }
}