package g2018.problem819;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("([!?',;.]|\\s)+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            String lowerCase = word.toLowerCase();
            map.put(lowerCase, map.getOrDefault(lowerCase, 0) + 1);
        }
        for (String ban : banned) {
            map.remove(ban);
        }
        int max = 0;
        String ret = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                ret = entry.getKey();
            }
        }
        return ret;
    }
}