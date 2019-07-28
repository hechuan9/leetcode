package f2019.problem536;

import support.TreeNode;

class Solution {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) return null;

        boolean negative = false;
        int i = 0;
        if (s.charAt(0) == '-') {
            negative = true;
            i++;
        }

        int numberStart = i;
        while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') i++;
        int abs = Integer.parseInt(s.substring(numberStart, i));
        TreeNode node = new TreeNode(negative ? -abs : abs);

        int leftStart = i;
        int left = 0;
        int right = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') right++;
            if (left == right) {
                node.left = str2tree(s.substring(leftStart + 1, i));
                break;
            }
            i++;
        }

        int rightStart = ++i;
        left = 0;
        right = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') left++;
            if (s.charAt(i) == ')') right++;
            if (left == right) {
                node.right = str2tree(s.substring(rightStart+1, i));
                break;
            }
            i++;
        }

        return node;
    }
}