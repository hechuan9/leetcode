package problem482;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","");
        int n = s.length();
        int first = n % k;
        List<String> sb = new LinkedList<>();
        if (first != 0) sb.add(s.substring(0, first));
        for (int i = first; i < n; i += k) {
            sb.add(s.substring(i, i+k));
        }
        return String.join("-", sb).toUpperCase();
    }
}