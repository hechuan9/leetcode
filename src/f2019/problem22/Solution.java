package f2019.problem22;

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", n, n);
        return res;
    }

    private void generate(List<String> res, String s, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) res.add(s);
        if (left > 0) generate(res, s + "(", left - 1, right);
        if (right > 0) generate(res, s + ")", left, right - 1);
    }
}