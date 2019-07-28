package f2019.problem38;

class Solution {
    public String countAndSay(int n) {
        String s = "1";
        if (n <= 0) return "";
        if (n == 1) return s;

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            char lastC = ' ';
            int count = 0;
            for (char c: s.toCharArray()) {
                if (c != lastC) {
                    if (count != 0) {
                        sb.append(count);
                        sb.append(lastC);
                    }
                    lastC = c;
                    count = 0;
                }
                count++;
            }

            if (count != 0) {
                sb.append(count);
                sb.append(lastC);
            }

            s = sb.toString();
        }

        return s;
    }
}