package f2019.problem158;

public class Solution {
    private char[] buf4 = new char[4];
    private int bufPtr = 0;
    private int bufCnt = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int len = 0;
        while (len < n) {
            if (bufPtr == 0) {
                bufCnt = read4(buf4);
            }

            if (bufCnt == 0) break;

            while (len < n && bufPtr < bufCnt) {
                buf[len++] = buf4[bufPtr++];
            }

            if (bufPtr >= bufCnt) bufPtr = 0;

        }
        return len;

    }

    private int read4(char[] buf) {
        return 0;
    }

}