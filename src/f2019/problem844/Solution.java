package f2019.problem844;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return convert(S).equals(convert(T));
    }

    private String convert(String s) {
        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                ret.append(c);
            } else {
                if (ret.length() > 0) ret.deleteCharAt(ret.length() - 1);
            }
        }
        return ret.toString();
    }
}