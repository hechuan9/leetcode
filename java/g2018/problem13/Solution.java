package g2018.problem13;

class Solution {
    public int romanToInt(String s) {
        boolean meetXV = false;
        boolean meetLC = false;
        boolean meetDM = false;

        int ret = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    if (meetXV) ret -= 1;
                    else ret += 1;
                    break;
                case 'V':
                    ret += 5;
                    meetXV = true;
                    break;
                case 'X':
                    if (meetLC) ret -= 10;
                    else ret += 10;
                    meetXV = true;
                    break;
                case 'L':
                    ret += 50;
                    meetLC = true;
                    break;
                case 'C':
                    if (meetDM) ret -= 100;
                    else ret += 100;
                    meetLC = true;
                    break;
                case 'D':
                    ret += 500;
                    meetDM = true;
                    break;
                case 'M':
                    ret += 1000;
                    meetDM = true;
                    break;
            }
        }
        return ret;
    }
}