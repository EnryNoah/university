package org.main.logsystem.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Task5 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        Task5 serializer = new Task5();
        String serializedTree1 = serializer.serialize(root1);
        System.out.println("Serialized Tree 1: " + serializedTree1);

        TreeNode deserializedRoot1 = serializer.deserialize(serializedTree1);

        // Example 2
        TreeNode root2 = null;

        String serializedTree2 = serializer.serialize(root2);
        System.out.println("Serialized Tree 2: " + serializedTree2);

        TreeNode deserializedRoot2 = serializer.deserialize(serializedTree2);
    }
}
