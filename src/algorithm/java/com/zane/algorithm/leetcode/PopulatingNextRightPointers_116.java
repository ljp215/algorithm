package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 16/3/31
 * Time: 22:12
 */
public class PopulatingNextRightPointers_116 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        connect(root, root);
    }

    public void connect(TreeLinkNode node, TreeLinkNode parent) {
        if (node == null || node.left == null || node.right == null) {
            return;
        }

        node.left.next = node.right;

        if (parent.next != null) {
            node.right.next = parent.next.left;
        }

        connect(node.left, node);
        connect(node.right, node);
    }
}
