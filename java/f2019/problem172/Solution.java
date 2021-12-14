package f2019.problem172;

class Solution {
    public int trailingZeroes(int n) {
        long power = 5;
        int res = 0;
        while (power <= n) {
            res += n / power;
            power *= 5;
        }
        return res;
    }
}