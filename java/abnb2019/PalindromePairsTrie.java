package airbnb;

import java.util.*;

class PalindromePairsTrie {
    class Node {
        int index;
        Map<Character, Node> children;
        List<Integer> list;

        public Node() {
            this.index = -1;
            this.children = new HashMap<>();
            this.list = new LinkedList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Node trie = new Node();
        for (int i = 0; i < words.length; i++) {
            insertWord(words[i], trie, i);
        }

        for (int i = 0; i < words.length; i++) {
            searchWord(words[i], trie, res, i);
        }
        return res;
    }

    private void searchWord(String s, Node node, List<List<Integer>> res, int index) {
        for (int i = 0; i < s.length(); i++) {
            if (node.index != -1 && node.index != index && isPalindrome(s.substring(i))) {
                res.add(Arrays.asList(index, node.index));
            }
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) return;
            node = node.children.get(c);
        }

        for (Integer pair1 : node.list) {
            if (index == pair1) continue;
            res.add(Arrays.asList(index, pair1));
        }
    }

    private void insertWord(String s, Node node, int index) {
        for (int i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            Node next = node.children.getOrDefault(c, new Node());
            node.children.put(c, next);
            if (isPalindrome(s.substring(0, i+1))) node.list.add(index);
            node = node.children.get(c);
        }
        node.list.add(index);
        node.index = index;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}