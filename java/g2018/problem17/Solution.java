package g2018.problem17;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.isEmpty()) return res;
        res.add("");
        String[] charMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        while (!digits.isEmpty()) {
            List<String> newRes = new LinkedList<>();
            int number = Character.getNumericValue(digits.charAt(0));
            for (String s : res) {
                for (char c : charMap[number].toCharArray()) {
                    newRes.add(s+c);
                }
            }
            res = newRes;
            digits = digits.substring(1, digits.length());
        }
        return res;
    }
}