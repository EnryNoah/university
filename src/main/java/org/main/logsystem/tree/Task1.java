package org.main.logsystem.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) { val = x; }

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

public class Task1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Task1 solution = new Task1();

        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println(solution.isSameTree(p1, q1));

        // Example 2
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println(solution.isSameTree(p2, q2));

        // Example 3
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);

        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println(solution.isSameTree(p3, q3));
    }
}
