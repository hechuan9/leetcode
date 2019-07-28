package f2019.problem8;

class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;

        int i = 0;
        int ret = 0;
        boolean negative = false;
        if (str.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        while (i != str.length() && Character.isDigit(str.charAt(i))) {
            try {
                ret = Math.addExact(Math.multiplyExact(ret, 10), str.charAt(i) - '0');
            } catch(ArithmeticException e) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }

        return negative ? -ret : ret;
    }
}