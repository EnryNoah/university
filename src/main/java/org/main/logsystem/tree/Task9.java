package org.main.logsystem.tree;

import java.util.Stack;

public class Task9 {
    public TreeNode recoverFromPreorder(String traversal) {
        if (traversal == null || traversal.isEmpty()) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int index = 0;

        while (index < traversal.length()) {
            int depth = 0;
            while (index < traversal.length() && traversal.charAt(index) == '-') {
                depth++;
                index++;
            }

            int value = 0;
            while (index < traversal.length() && Character.isDigit(traversal.charAt(index))) {
                value = value * 10 + (traversal.charAt(index) - '0');
                index++;
            }

            TreeNode node = new TreeNode(value);

            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Task9 treeReconstruction = new Task9();

        // Example 1
        String traversal1 = "1-2--3--4-5--6--7";
        TreeNode root1 = treeReconstruction.recoverFromPreorder(traversal1);
        System.out.println(root1.val);

        // Example 2
        String traversal2 = "1-2--3---4-5--6---7";
        TreeNode root2 = treeReconstruction.recoverFromPreorder(traversal2);
        System.out.println(root2.val);

        // Example 3
        String traversal3 = "1-401--349---90--88";
        TreeNode root3 = treeReconstruction.recoverFromPreorder(traversal3);
        System.out.println(root3.val);
    }
}
