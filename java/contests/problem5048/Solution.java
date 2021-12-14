package context.problem5048;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            map[c-'a']++;
        }

        int length = 0;
        for (String word : words) {
            if (canBeForm(word, map)) length += word.length();
        }
        return length;
    }

    private boolean canBeForm(String word, int[] _map) {
        int[] map = Arrays.copyOf(_map, 26);

        for (char c : word.toCharArray()) {
            if (map[c-'a'] - 1 < 0) return false;
            map[c-'a']--;
        }
        return true;
    }
}