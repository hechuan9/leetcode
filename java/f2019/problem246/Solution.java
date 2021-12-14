package f2019.problem246;

class Solution {
    private int i;

    public boolean isStrobogrammatic(String num) {
        StringBuilder reverse = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            switch (num.charAt(i)) {
                case '0': reverse.append("0"); break;
                case '1': reverse.append("1"); break;
                case '2': return false;
                case '3': return false;
                case '4': return false;
                case '5': return false;
                case '6': reverse.append("9"); break;
                case '7': return false;
                case '8': reverse.append("8"); break;
                case '9': reverse.append("6"); break;
            }
        }
        return reverse.toString().equals(num);
    }
}