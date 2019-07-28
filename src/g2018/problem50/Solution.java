package g2018.problem50;

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double ret = 1;
        double cur = x;
        while (n != 0) {
            if (n % 2 == 1) ret *= cur;
            cur = cur * cur;
            n /= 2;
        }
        return ret;
    }
}