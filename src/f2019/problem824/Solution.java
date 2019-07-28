package f2019.problem824;

import java.util.Arrays;
import java.util.List;

class Solution {
    public String toGoatLatin(String S) {
        List<Character> vowels = Arrays.asList('A','E','I','O','U','a','e','i','o','u');
        String[] stringArray = S.split(" ");
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (String s : stringArray) {
            char firstC = s.charAt(0);
            if (vowels.contains(firstC)) {
                sb.append(s);
            } else {
                sb.append(s.substring(1));
                sb.append(firstC);
            }
            sb.append("ma");

            for (int i = 0; i < count; i++) {
                sb.append('a');
            }
            count++;

            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}