package org.main.logsystem.tree;

import static java.lang.Integer.MAX_VALUE;

public class Task4 {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverseInOrder(root, k);
        return result;
    }

    private void traverseInOrder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        traverseInOrder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        if (node.right != null) {
            traverseInOrder(node.right, k);
        }
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);

        Task4 kthSmallestElementBST = new Task4();
        int result1 = kthSmallestElementBST.kthSmallest(root1, 1);
        System.out.println("EX1: " + result1);

        // Example 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(null);
        root2.left.left.left.left = new TreeNode(1);

        int result2 = kthSmallestElementBST.kthSmallest(root2, 3);
        System.out.println("EX2: " + result2);
    }
}

