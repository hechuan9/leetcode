package f2019.problem438;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();

        if (s.length() < p.length()) return res;

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int[] sMap = new int[26];
        int n = p.length();

        for (int i = 0; i < n; i++) {
            sMap[s.charAt(i)-'a']++;
        }

        int i = 0;
        int j = n;
        while (j != s.length()) {
            if (isAnagram(pMap, sMap)) res.add(i);

            sMap[s.charAt(i)-'a']--;
            sMap[s.charAt(j)-'a']++;

            i++; j++;
        }

        if (isAnagram(pMap, sMap)) res.add(i);

        return res;
    }

    private boolean isAnagram(Map<Character, Integer> pMap, int[] sMap) {
        for (Map.Entry<Character, Integer> pair : pMap.entrySet()) {
            if (!pair.getValue().equals(sMap[pair.getKey()-'a'])) return false;
        }
        return true;
    }


}