package f2019.problem211;

import java.util.*;

class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        boolean word;
        char c;
        Map<Character, TrieNode> children;

        public TrieNode(char c) {
            this.c = c;
            children = new HashMap<>();
            word = false;
        }
    }

    TrieNode root = new TrieNode('0');

    public WordDictionary() {
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                TrieNode nextNode = new TrieNode(c);
                node.children.put(c, nextNode);
            }
            node = node.children.get(c);
        }

        node.word = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        List<TrieNode> queue = new LinkedList<>();
        queue.add(root);

        for (char c : word.toCharArray()) {
            List<TrieNode> nextQueue = new LinkedList<>();
            for (TrieNode node : queue) {
                if (c != '.') {
                    if (node.children.containsKey(c)) {
                        TrieNode nextNode = node.children.get(c);
                        nextQueue.add(nextNode);
                    }
                } else { //.
                    nextQueue.addAll(node.children.values());
                }
            }
            if (nextQueue.isEmpty()) return false;
            queue = nextQueue;
        }

        for (TrieNode node : queue) {
            if (node.word) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */