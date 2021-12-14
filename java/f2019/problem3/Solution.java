package f2019.problem3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }

            res = Math.max(res, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}