package f2019.problem953;

import java.util.Arrays;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }


        for (int i = 0; i < words.length - 1; i++) {
            if (!word1BeforeWord2(words[i], words[i+1], map)) return false;
        }

        return true;
    }

    private boolean word1BeforeWord2(String word1, String word2, int[] map) {
        for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
            if (map[word1.charAt(j)-'a'] > map[word2.charAt(j)-'a']) return false;
            if (map[word1.charAt(j)-'a'] < map[word2.charAt(j)-'a']) return true;
        }
        return word1.length() <= word2.length();
    }
}