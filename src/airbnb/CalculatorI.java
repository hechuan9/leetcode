package airbnb;

import java.util.Stack;

public class CalculatorI {
    public int calculate(String s) {
        int result = 0;
        int sign  = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = (c - '0');
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result = result + sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.add(sign);
                stack.add(result);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = stack.pop() + stack.pop() * result;
            }
        }
        return result;
    }
}
