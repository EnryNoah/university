package org.main.logsystem.tree;

public class Task6 {
    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxPathSum;
    }

    private int findMaxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, findMaxPathSum(node.left));
        int rightSum = Math.max(0, findMaxPathSum(node.right));

        maxPathSum = Math.max(maxPathSum, leftSum + rightSum + node.val);

        return Math.max(leftSum, rightSum) + node.val;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        Task6 maxPathSumBinaryTree = new Task6();
        int result1 = maxPathSumBinaryTree.maxPathSum(root1);
        System.out.println("Max Path Sum for Example 1: " + result1);

        // Example 2
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        int result2 = maxPathSumBinaryTree.maxPathSum(root2);
        System.out.println("Max Path Sum for Example 2: " + result2);
    }
}
