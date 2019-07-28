package g2018.problem202;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        while (num != 1) {
            int newNum = 0;
            while (num != 0) {
                newNum += Math.pow((num % 10), 2);
                num /= 10;
            }
            num = newNum;

            if (!set.add(num)) return false;

        }
        return true;
    }
}