package f2019.problem29;

class Solution {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0) ^ (divisor > 0);
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long lmul = ldivide(ldividend, ldivisor);

        if (lmul > Integer.MAX_VALUE) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return negative ? (int)-lmul : (int)lmul;
    }

    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;

        long sum = ldivisor;
        long mul = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            mul += mul;
        }
        return mul + ldivide(ldividend - sum, ldivisor);
    }
}