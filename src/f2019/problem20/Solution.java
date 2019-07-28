package f2019.problem20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch(c) {
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
            }
        }
        return stack.isEmpty();
    }
}