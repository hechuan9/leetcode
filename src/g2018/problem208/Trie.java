package problem208;

import java.util.HashMap;
import java.util.Map;

class Trie {
    class Node {
        Map<Character, Node> children;
        boolean word;
        char c;

        Node(char c) {
            this.c = c;
            children = new HashMap<>();
            word = false;
        }
    }

    Node dummy = new Node('0');

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = dummy;
        for (int i = 0; i < word.length(); i++) {
            Node nextNode;
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                nextNode = node.children.get(c);
            } else {
                nextNode = new Node(c);
                node.children.put(c, nextNode);
            }
            node = nextNode;
        }
        node.word = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = dummy;
        for (int i = 0; i < word.length(); i++) {
            Node nextNode;
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                nextNode = node.children.get(c);
            } else {
                return false;
            }
            node = nextNode;
        }
        return node.word ? true : false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = dummy;
        for (int i = 0; i < prefix.length(); i++) {
            Node nextNode;
            char c = prefix.charAt(i);
            if (node.children.containsKey(c)) {
                nextNode = node.children.get(c);;
            } else {
                return false;
            }
            node = nextNode;
        }
        return true;
    }
}