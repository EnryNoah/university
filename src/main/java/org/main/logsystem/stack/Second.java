package org.main.logsystem.stack;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    Integer val;
    TreeNode left, right;

    public TreeNode(Integer val) {
        this.val = val;
    }
}

public class Second {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }

    private static void inorderTraversalHelper(TreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversalHelper(node.left, result);
            if (node.val != null) {
                result.add(node.val);
            }
            inorderTraversalHelper(node.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.right = new TreeNode(null);
        root1.right.right.right = new TreeNode(3);
        System.out.println(inorderTraversal(root1));

        System.out.println(inorderTraversal(null));

        TreeNode root3 = new TreeNode(1);
        System.out.println(inorderTraversal(root3));
    }
}

