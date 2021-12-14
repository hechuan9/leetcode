package f2019.problem43;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) return "";

        int m = num1.length();
        int n = num2.length();
        int[] digits = new int[m+n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n -1; j >= 0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = digits[p2] + mul;
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < digits.length && digits[i] == 0) i++;
        for (int j = i; j < digits.length; j++) sb.append(digits[j]);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}