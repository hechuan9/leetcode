package problem166;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long absNumerator = Math.abs((long)numerator);
        long absDenominator = Math.abs((long)denominator);
        sb.append(absNumerator/absDenominator);
        long reminder = absNumerator % absDenominator;
        if (reminder == 0) return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            reminder *= 10;
            if (map.containsKey(reminder)) {
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                return sb.toString();
            }
            map.put(reminder, sb.length());
            sb.append(reminder/absDenominator);
            reminder %= absDenominator;
        }
        return sb.toString();
    }
}