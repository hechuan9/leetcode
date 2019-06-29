package problem131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<>();
        backTrace(ret, new ArrayList<>(), s);
        return ret;
    }

    private void backTrace(List<List<String>> ret, List<String> curr, String s) {
        if (s.length() == 0) {
            ret.add(new ArrayList<>(curr));
        }
        for (int i = 1; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            if (isPalindrome(subString)) {
                curr.add(subString);
                backTrace(ret, curr, s.substring(i, s.length()));
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}