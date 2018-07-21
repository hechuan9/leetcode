package problem326;

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n != 1) {
            int reminder = n % 3;
            if (reminder != 0) return false;
            n = n / 3;
        }
        return true;
    }
}