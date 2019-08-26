package f2019.problem482;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String s = S.replace("-", "");
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        List<String> sections = new LinkedList<>();
        if (n % K != 0) {
            sections.add(s.substring(0, n % K).toUpperCase());
        }
        for (int i = n % K; i < n; i += K) {
            sections.add(s.substring(i, i + K).toUpperCase());
        }
        return String.join("-", sections);
    }
}