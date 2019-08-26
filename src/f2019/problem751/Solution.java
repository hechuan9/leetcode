package f2019.problem751;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new LinkedList<>();
        String[] ip_split = ip.split("\\.");
        long x = 0;
        for (int i = 0; i < 4; i++) {
            x = x * 256 + Long.parseLong(ip_split[i]);
        }
        while (n > 0) {
            long count = x & -x;

            while (count > n) { // for example count is 8 but we only want to 2 more ips
                count /= 2;
            }

            res.add(oneCIDR(x, count));
            n = n - (int) count;
            x = x + (int) count;
        }

        return res;

    }

    private String oneCIDR(long ip, long count) {
        String group4 = Long.toString(ip & 255);
        ip = ip / 256;
        String group3 = Long.toString(ip & 255);
        ip = ip / 256;
        String group2 = Long.toString(ip & 255);
        ip = ip / 256;
        String group1 = Long.toString(ip & 255);

        int len = 0;
        while (count > 0) {
            count /= 2;
            len++;
        }
        int mask = 32 - (len - 1);

        return group1 + "." + group2 + "." + group3 + "." + group4 + "/" + mask;
    }
}