package com.zane.algorithm.leetcode;


import com.zane.algorithm.model.TreeNode;

/**
 * Created by jinpiluo on 3/29/16.
 */
public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = getDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }

        int rightDepth = getDepth(node.right);
        if (rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
