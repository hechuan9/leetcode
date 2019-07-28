package f2019.problem282;

import java.util.LinkedList;
import java.util.List;

class Solution {
    List<String> res = new LinkedList<>();
    String num;
    int target;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        dfs("", 0, 0, 0);
        return res;
    }

    private void dfs(String expr, int pos, long prev, long curr) {
        if (pos == num.length()) {
            if (curr == target) res.add(expr);
            return;
        }


        for (int i = pos + 1; i <= num.length(); i++) {
            String subString = num.substring(pos, i);
            if (num.charAt(pos) == '0' && (i - pos) > 1) break;
            long n = Long.valueOf(subString);
            if (n > Integer.MAX_VALUE) break;
            if (pos == 0) {
                dfs(subString + "", i, n, n);
            } else {
                dfs(expr + "+" + subString, i, n, curr + n);
                dfs(expr + "-" + subString, i, -n, curr - n);
                dfs(expr + "*" + subString, i, prev * n, curr - prev + prev * n);
            }
        }

    }
}