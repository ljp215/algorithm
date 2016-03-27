package main.com.zane.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinpiluo on 3/25/16.
 */
public class KthSmallestElementInBST_230 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> preOrderNodes = new ArrayList<>();
        preOrderSearch(root, preOrderNodes);
        return preOrderNodes.get(k - 1);
    }

    public void preOrderSearch(TreeNode node, List<Integer> preOrderNodes) {
        if (node.left != null) {
            preOrderSearch(node.left, preOrderNodes);
        }

        preOrderNodes.add(node.val);

        if (node.right != null) {
            preOrderSearch(node.right, preOrderNodes);
        }
    }

    // better keep these two variables in a wrapper class
    private static int number = 0;
    private static int count = 0;

    public int kthSmallestDFS(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count <= 0) {
            if (count == 0) {
                number = n.val;
            }
            return;
        }
        if (n.right != null) helper(n.right);
    }


    public static void main(String[] args) {
        KthSmallestElementInBST_230 kthSmallestElementInBST = new KthSmallestElementInBST_230();

        /**
         *     4
         *    / \
         *   3  5
         *  /
         * 1
         *  \
         *   2
         */
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);

        node4.right = node5;
        node2.left = node4;
        node1.left = node2;
        node1.right = node3;

        System.out.println(kthSmallestElementInBST.kthSmallestDFS(node1, 3));
    }
}