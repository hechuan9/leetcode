package f2019.problem340;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) return 0;

        int distinctCharacter = 0;
        Map<Character, Integer> dict = new HashMap<>();

        int slow = 0;
        int fast = 0;
        int res = Integer.MIN_VALUE;

        while (fast != s.length()) {
            char fastChar = s.charAt(fast++);
            int fastCount = dict.getOrDefault(fastChar, 0);
            if (fastCount == 0) {
                distinctCharacter++;
            }
            dict.put(fastChar, fastCount + 1);

            if (distinctCharacter <= k) {
                res = Math.max(res, fast - slow);
            }

            while (distinctCharacter > k) {
                char slowChar = s.charAt(slow++);
                int slowCount = dict.get(slowChar);
                if (slowCount == 1) {
                    distinctCharacter--;
                }
                dict.put(slowChar, slowCount - 1);
            }
        }
        return res;
    }
}