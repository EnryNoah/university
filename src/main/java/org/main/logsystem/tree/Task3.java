package org.main.logsystem.tree;

public class Task3 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        Task3 inverter = new Task3();
        TreeNode invertedRoot1 = inverter.invertTree(root1);
        System.out.println("EXAMPLE 1");
        printTree(invertedRoot1);

        // Example 2
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);


        TreeNode invertedRoot2 = inverter.invertTree(root2);
        System.out.println("EXAMPLE 2");
        printTree(invertedRoot2);

        // Example 3
        TreeNode root3 = null;
        TreeNode invertedRoot3 = inverter.invertTree(root3);
        System.out.println("EXAMPLE 3");
        printTree(invertedRoot3);
    }

    public static void printTree(TreeNode root) {
        printTree(root, 0);
    }

    private static void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(node.val);

        printTree(node.right, depth + 1);
        printTree(node.left, depth + 1);
    }
}
