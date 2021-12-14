package g2018.problem8;

class Solution {
    public int myAtoi(String str) {
        int n = str.length();
        int i = 0;
        // Skip all spaces
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        boolean neg = false;
        if (i < n) {
            if (str.charAt(i) == '-') {
                neg = true;
                i++;
            } else if (str.charAt(i) == '+') {
                neg = false;
                i++;
            }
        }

        int res = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            try {
                res = Math.addExact(Math.multiplyExact(res, 10), str.charAt(i) - '0');
            } catch(ArithmeticException e) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;

        }

        return neg ? -res : res;
    }
}