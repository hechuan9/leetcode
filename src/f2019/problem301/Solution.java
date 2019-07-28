package f2019.problem301;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> res = new LinkedList<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        removeInvalidParentheses(s, 0, left, right);
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    private void removeInvalidParentheses(String s, int start, int left, int right) {
        if (left == 0 && right == 0) {
            if(isValid(s)) res.add(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i-1)) continue;
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String newS = s.substring(0, i) + s.substring(i+1);

                if (right > 0) removeInvalidParentheses(newS, i, left, right - 1);
                else if (left > 0) removeInvalidParentheses(newS, i, left - 1, right);
            }
        }
    }
}