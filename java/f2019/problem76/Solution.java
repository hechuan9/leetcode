package f2019.problem76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : t.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }

        int slow = 0;
        int fast = 0;
        int total = 0;
        int minLen = Integer.MAX_VALUE;
        int index = 0;

        while (fast != s.length()) {
            char cFast = s.charAt(fast++);
            if (dict.get(cFast) == null) continue;

            int fCount = dict.get(cFast);
            dict.put(cFast, fCount - 1);
            if (fCount == 1) total++;

            while (total == dict.size()) {
                if (minLen > fast - slow) {
                    minLen = fast - slow;
                    index = slow;
                }

                char charSlow = s.charAt(slow++);
                if (dict.get(charSlow) == null) continue;

                int countSlow = dict.get(charSlow);
                dict.put(charSlow, countSlow + 1);
                if (countSlow == 0) total--;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}