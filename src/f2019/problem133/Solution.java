package f2019.problem133;


import java.util.*;

class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val, new LinkedList<>()));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            for (Node child : n.neighbors) {
                if (!map.containsKey(child)) {
                    queue.add(child);
                    map.put(child, new Node(child.val, new LinkedList<>()));
                }
                map.get(n).neighbors.add(map.get(child));
            }
        }

        return node;

    }
}