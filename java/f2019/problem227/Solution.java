package f2019.problem227;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        char lastOp = '+';
        s += '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == ' ') {
                continue;
            } else {
                if (lastOp == '+') stack.add(num);
                if (lastOp == '-') stack.add(-num);
                if (lastOp == '*') stack.add(stack.pop() * num);
                if (lastOp == '/') stack.add(stack.pop() / num);
                num = 0;
                lastOp = c;
            }
        }

        int res = 0;
        for (int adder : stack) {
            res += adder;
        }
        return  res;
    }
}
