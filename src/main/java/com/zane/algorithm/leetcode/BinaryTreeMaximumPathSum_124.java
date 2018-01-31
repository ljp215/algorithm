package com.zane.algorithm.leetcode;

import com.zane.algorithm.model.TreeNode;

/**
 * Author: luojinping
 * Date: 2018/1/28
 * Time: 22:49
 */
public class BinaryTreeMaximumPathSum_124 {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
