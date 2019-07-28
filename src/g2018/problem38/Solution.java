package g2018.problem38;

class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i=1; i<n; i++) {
            char lastNum = sb.charAt(0);
            int count = 0;
            StringBuilder newSb = new StringBuilder();
            for (int j=0; j < sb.length(); j++) {
                if (sb.charAt(j) != lastNum) {
                    newSb.append(count);
                    newSb.append(lastNum);
                    count = 0;
                    lastNum = sb.charAt(j);
                }
                count++;
            }
            newSb.append(count);
            newSb.append(lastNum);
            sb = newSb;
        }

        return sb.toString();
    }


}