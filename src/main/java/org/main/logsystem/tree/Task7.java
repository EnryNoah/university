package org.main.logsystem.tree;

public class Task7 {
    private int cameras = 0;

    public int minCameraCover(TreeNode root) {
        int result = dfs(root);
        return cameras + (result == 0 ? 1 : 0);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 2;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cameras++;
            return 1;
        }

        return (left == 1 || right == 1) ? 2 : 0;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(0);
        root1.right = null;
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(0);

        Task7 binaryTreeCameras = new Task7();
        int result1 = binaryTreeCameras.minCameraCover(root1);
        System.out.println("Minimum Cameras for Example 1: " + result1);

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(0);
        root2.right = null;
        root2.left.left = new TreeNode(0);
        root2.left.right = null;
        root2.left.left.left = new TreeNode(0);

        int result2 = binaryTreeCameras.minCameraCover(root2);
        System.out.println("Minimum Cameras for Example 2: " + result2);
    }
}
