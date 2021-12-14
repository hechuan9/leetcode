package g2018.problem14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String common = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String compareString = strs[i];
            StringBuilder newCommon = new StringBuilder();
            for (int j = 0; j < Math.min(common.length(), compareString.length()); j++) {
                if (common.charAt(j) == compareString.charAt(j)) newCommon.append(common.charAt(j));
                else break;
            }
            common = newCommon.toString();
        }
        return common;
    }
}