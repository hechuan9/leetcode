package f2019.problem146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private int count = 0;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        removeNode(node);
        insertNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) { // insert case
            node = new Node(key, value);
            if (count < capacity) {
                count++;
            } else {
                Node last = popTail();
                map.remove(last.key);
            }
            insertNode(node);
            map.put(key, node);
        } else {
           node = removeNode(node);
           node.value = value;
           insertNode(node);
        }
    }

    private Node removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
        return node;
    }

    private void insertNode(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private Node popTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }
}