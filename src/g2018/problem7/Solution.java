package problem7;

class Solution {
    public int reverse(int x) {
        long output = 0;
        int reminder = x;
        while (reminder != 0) {
            int reversion = reminder % 10;
            reminder = reminder / 10;
            output = output * 10 + reversion;
        }
        if (output > Integer.MAX_VALUE || output < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)output;
    }
}