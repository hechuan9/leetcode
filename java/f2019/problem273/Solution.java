package f2019.problem273;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        List<String> sb = new LinkedList<>();

        int level = 0;
        while (num != 0) {
            if (num % 1000 != 0) {
                sb.add(0, THOUSANDS[level]);
                sb.addAll(0, buildLessThan1000(num % 1000));
            }

            num /= 1000;
            level++;
        }

        return sb.stream().filter(s->!s.isEmpty()).collect(Collectors.joining(" "));
    }

    private List<String> buildLessThan1000(int num) {
        List<String> sb = new LinkedList<>();
        if (num == 0) return sb;

        int hundreds = num / 100;

        if (hundreds > 0) {
            sb.add(LESS_THAN_20[hundreds]);
            sb.add("Hundred");
        }

        num = num % 100;
        if (num < 20) {
            sb.add(LESS_THAN_20[num]);
        } else {
            int tens = num / 10;
            num = num % 10;
            sb.add(TENS[tens]);
            sb.add(LESS_THAN_20[num]);
        }

        return sb;
    }
}