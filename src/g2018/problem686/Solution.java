package problem686;

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int aLength = a.length();
        int count;
        for (int i = 0; i < aLength; i++) {
            if (a.charAt(i) == b.charAt(0)) { // can start matching
                count = 0;
                int aIndex = i;
                boolean matched = true;
                for (int j = 0; j < b.length(); j++) {
                    if (a.charAt(aIndex) != b.charAt(j)) {
                        matched = false;
                        break;
                    }
                    aIndex = aIndex + 1;
                    if (aIndex == aLength) {
                        count++;
                        aIndex = 0;
                    }
                }
                if (matched) {
                    int trail = (aIndex == 0) ? 0 : 1;
                    return count + trail;
                }
            }
        }
        return -1;
    }
}