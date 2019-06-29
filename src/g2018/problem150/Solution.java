package g2018.problem150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        for (String token : tokens) {
            int a, b;
            switch (token) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b+a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b*a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}