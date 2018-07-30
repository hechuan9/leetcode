package problem20;

import java.util.Stack;

// Can use compliment
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] charA = s.toCharArray();
        for (char c : charA) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') return false;
                    break;
            }
        }
        return stack.empty();
    }
}