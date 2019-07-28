package g2018.problem62;

class MathSolution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int big = Math.max(m,n) - 1;
        int small = Math.min(m,n) - 1;
        long result = 1;
        for (int i = 1; i <= small; i++) {
            result = result * (i + big) / i;
        }
        return (int)result;
    }
}