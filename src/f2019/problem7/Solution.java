package f2019.problem7;

class Solution {
    public int reverse(int x) {
        boolean negative = x < 0;
        int res = 0;

        x = Math.abs(x);
        try {
            while (x != 0) {
                int rem = x % 10;
                x = x / 10;
                res = Math.multiplyExact(res, 10);
                res = Math.addExact(res, rem);
            }
        } catch(ArithmeticException e) {
            return 0;
        }
        return negative ? -res : res;
    }
}