package g2018.problem49;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c-'a']++;
            }
            StringBuilder hashBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    hashBuilder.append(count[i]);
                    hashBuilder.append('a'+i);
                }
            }
            String hash = hashBuilder.toString();
            List<String> value = map.getOrDefault(hash, new LinkedList<>());
            value.add(s);
            map.put(hash, value);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}