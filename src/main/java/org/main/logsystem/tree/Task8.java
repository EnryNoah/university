package org.main.logsystem.tree;

import java.util.*;

public class Task8 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Map<Integer, List<int[]>> columnMap = new HashMap<>();
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = Integer.MIN_VALUE;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        nodeQueue.offer(root);
        columnQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Map<Integer, List<int[]>> tempMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int column = columnQueue.poll();

                tempMap.computeIfAbsent(column, k -> new ArrayList<>()).add(new int[]{node.val, column});

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    columnQueue.offer(column - 1);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    columnQueue.offer(column + 1);
                }
            }

            for (Map.Entry<Integer, List<int[]>> entry : tempMap.entrySet()) {
                int column = entry.getKey();
                List<int[]> columnNodes = entry.getValue();
                Collections.sort(columnNodes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

                columnMap.computeIfAbsent(column, k -> new ArrayList<>()).addAll(columnNodes);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            if (columnMap.containsKey(i)) {
                List<Integer> columnResult = new ArrayList<>();
                for (int[] nodeInfo : columnMap.get(i)) {
                    columnResult.add(nodeInfo[0]);
                }
                result.add(columnResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        Task8 verticalTraversalBinaryTree = new Task8();
        List<List<Integer>> result1 = verticalTraversalBinaryTree.verticalTraversal(root1);
        System.out.println("Vertical Traversal for Example 1: " + result1);

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);

        List<List<Integer>> result2 = verticalTraversalBinaryTree.verticalTraversal(root2);
        System.out.println("Vertical Traversal for Example 2: " + result2);

        // Example 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(6);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(7);

        List<List<Integer>> result3 = verticalTraversalBinaryTree.verticalTraversal(root3);
        System.out.println("Vertical Traversal for Example 3: " + result3);
    }
}
