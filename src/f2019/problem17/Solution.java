package f2019.problem17;

import java.util.*;

class Solution {
    Map<Character, List<Character>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        helper(res, digits, "");
        return res;
    }

    private void helper(List<String> res, String digits, String s) {
        if (digits.length() == 0) {
            res.add(s);
            return;
        }

        char first = digits.charAt(0);
        for (char c : map.get(first)) {
            helper(res, digits.substring(1), s + c);
        }
    }
}