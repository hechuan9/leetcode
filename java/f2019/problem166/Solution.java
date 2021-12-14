package f2019.problem166;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean negative = (numerator > 0) ^ (denominator > 0);
        StringBuilder sb = new StringBuilder();
        if (negative) sb.append("-");

        long lnumerator = Math.abs((long)numerator);
        long ldenominator = Math.abs((long)denominator);
        sb.append(lnumerator/ldenominator);
        if (lnumerator % ldenominator == 0) return sb.toString();

        sb.append(".");

        Map<Long, Integer> map = new HashMap<>();
        long lreminder = lnumerator % ldenominator;
        while (lreminder != 0) {
            lnumerator = lreminder * 10;
            lreminder = lnumerator % ldenominator;
            sb.append(lnumerator / ldenominator);
            if (map.containsKey(lreminder)) {
                sb.insert(map.get(lreminder), "(");
                sb.append(")");
                break;
            }
            map.put(lreminder, sb.length());
        }
        return sb.toString();
    }
}