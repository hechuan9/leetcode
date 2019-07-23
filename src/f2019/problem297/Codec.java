package f2019.problem297;

import support.TreeNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> strings = new LinkedList<>();
        serialize(strings, root);
        return String.join(",", strings);

    }

    private void serialize(List<String> strings, TreeNode node) {
        if (node == null) {
            strings.add("#");
            return;
        }
        strings.add(Integer.toString(node.val));
        serialize(strings, node.left);
        serialize(strings, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        Iterator<String> strings = Arrays.asList(data.split(",")).iterator();
        return deserialize(strings);
    }

    public TreeNode deserialize(Iterator<String> strings) {
        String next = strings.next();
        if (next.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(next));
        node.left = deserialize(strings);
        node.right = deserialize(strings);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));