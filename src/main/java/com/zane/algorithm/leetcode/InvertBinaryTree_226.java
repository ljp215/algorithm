package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/9/23
 * Time: 16:55
 */
public class InvertBinaryTree_226 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = null, right = null;
            if (root.left != null) {
                right = invertTree(root.left);
            }

            if (root.right != null) {
                left = invertTree(root.right);
            }

            root.left = left;
            root.right = right;
            return root;
        }
    }
}
