package problem127;

import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        while (!stack.isEmpty()) {
            count++;
            Stack<String> newStack = new Stack<>();
            while (!stack.isEmpty()) {
                String cur = stack.pop();
                if (cur.equals(endWord)) return count;
                ListIterator<String> itr = wordList.listIterator();
                while (itr.hasNext()) {
                    String s = itr.next();
                    if (compare(cur, s)) {
                        newStack.push(s);
                        itr.remove();
                    }
                }

            }
            stack = newStack;
        }
        return 0;

    }


    private boolean compare(String a, String b) {
        int n = a.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}