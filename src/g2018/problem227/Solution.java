package problem227;

import java.util.*;

class Solution {
    public int calculate(String s) {
        List<Integer> numbers = new LinkedList<>();
        List<Character> operations = new LinkedList<>();
        int number = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    numbers.add(number);
                    operations.add(c);
                    number = 0;
                    break;
                default:
                    number *= 10;
                    number += c - '0';
            }
        }
        numbers.add(number);

        // Deal * /
        ListIterator<Character> operationItr = operations.listIterator();
        ListIterator<Integer> numberItr = numbers.listIterator();
        Integer prevNum = numberItr.next();
        Integer num;
        while (operationItr.hasNext()) {
            switch (operationItr.next()) {
                case '+':
                    prevNum = numberItr.next();
                    break;
                case '-':
                    prevNum = numberItr.next();
                    break;
                case '*':
                    operationItr.remove();
                    numberItr.remove();
                    num = numberItr.next();
                    prevNum *= num;
                    numberItr.set(prevNum);
                    break;
                case '/':
                    operationItr.remove();
                    numberItr.remove();
                    num = numberItr.next();
                    prevNum /= num;
                    numberItr.set(prevNum);
                    break;
            }
        }

        // Deal + -
        operationItr = operations.listIterator();
        numberItr = numbers.listIterator();
        prevNum = numberItr.next();
        while (operationItr.hasNext()) {
            switch (operationItr.next()) {
                case '+':
                    operationItr.remove();
                    numberItr.remove();
                    num = numberItr.next();
                    prevNum += num;
                    numberItr.set(prevNum);
                    break;
                case '-':
                    operationItr.remove();
                    numberItr.remove();
                    num = numberItr.next();
                    prevNum -= num;
                    numberItr.set(prevNum);
                    break;
            }
        }
        return prevNum;
    }
}