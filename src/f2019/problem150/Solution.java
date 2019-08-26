package f2019.problem150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
           switch (token) {
               case "*":
                   stack.push(stack.pop()*stack.pop());
                   break;
               case "+":
                   stack.push(stack.pop()+stack.pop());
                   break;
               case "-":
                   stack.push(-stack.pop()+stack.pop());
                   break;
               case "/":
                   int divisor = stack.pop();
                   int dividend = stack.pop();
                   stack.push(dividend/divisor);
                   break;
               default:
                   stack.push(Integer.parseInt(token));
           }
        }

        return stack.pop();
    }
}