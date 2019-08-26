package airbnb;

import java.util.*;

class PalindromePairsMap {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            map.put(words[i], i);
        }

        for (int i=0; i<words.length; i++) {
            for (int j=0; j<=words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                String suffix = words[i].substring(j);
                if (isPalindrome(prefix)) {
                    String reverseSuffix = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(reverseSuffix) && map.get(reverseSuffix) != i) {
                        res.add(Arrays.asList(map.get(reverseSuffix), i));
                    }
                }
                if (isPalindrome(suffix)) {
                    String reversePrefix = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(reversePrefix) && map.get(reversePrefix) != i && suffix.length()!=0) {
                        res.add(Arrays.asList(i, map.get(reversePrefix)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}