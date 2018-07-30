package problem155;

import java.util.Stack;

class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> dataStack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
        dataStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.empty()) minStack.push(x);
        if (x <= minStack.peek()) minStack.push(x);
    }

    public void pop() {
        int x = dataStack.pop();
        if (x == minStack.peek()) minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}