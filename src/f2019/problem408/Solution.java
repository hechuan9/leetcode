package f2019.problem408;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) == '0') return false;
            else if (Character.isLetter(abbr.charAt(j))) {
                if (word.charAt(i) != abbr.charAt(j)) return false;
                i++;
                j++;
            } else {
                int start = j;
                while (j < abbr.length() && !Character.isLetter(abbr.charAt(j))) {
                    j++;
                }
                int count = Integer.valueOf(abbr.substring(start,j));
                i += count;
            }

        }

        return i == word.length() && j == abbr.length();
    }
}