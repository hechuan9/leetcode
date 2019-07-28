package f2019.problem157;

public class Solution  {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (n == 0) return 0;

        char[] buf4 = new char[4];
        int len = 0;

        while (n != 0) {
            int len4 = read4(buf4);
            int writeLen = Math.min(len4, n);

            for (int i = 0; i < writeLen; i++) buf[len + i] = buf4[i];

            n -= writeLen;
            len += writeLen;

            if (len4 != 4) break;
        }

        return len;
    }

    private int read4(char[] buf) {
        return 0;
    }
}