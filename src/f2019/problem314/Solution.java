package f2019.problem314;

import support.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> vIndexQ = new LinkedList<>();
        nodeQ.add(root);
        vIndexQ.add(0);

        while (!nodeQ.isEmpty()) {
            Queue<TreeNode> newLevel = new LinkedList<>();
            for (TreeNode node : nodeQ) {
                int vIndex = vIndexQ.poll();
                List<Integer> nodes = map.getOrDefault(vIndex, new LinkedList<>());
                nodes.add(node.val);
                map.put(vIndex, nodes);

                if (node.left != null) {
                    newLevel.add(node.left);
                    vIndexQ.add(vIndex - 1);
                }

                if (node.right != null) {
                    newLevel.add(node.right);
                    vIndexQ.add(vIndex + 1);
                }
            }
            nodeQ = newLevel;
        }


        return map.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}