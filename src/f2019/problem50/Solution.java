package f2019.problem50;

class Solution {
    public double myPow(double x, int n) {
        long absn = Math.abs((long)n);

        double multiplier = x;
        double pow = 1;
        while (absn != 0) {
            if (absn % 2 == 1) pow *= multiplier;
            multiplier *= 2;
            absn /= 2;
        }

        return (n < 0) ? 1/pow : pow;
    }
}