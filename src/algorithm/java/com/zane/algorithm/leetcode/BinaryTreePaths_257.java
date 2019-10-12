package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 * <p>
 * Created by jinpiluo on 3/23/16.
 */
public class BinaryTreePaths_257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        String rootNode = String.valueOf(root.val);

        List<String> leftPaths = binaryTreePaths(root.left);
        addPaths(leftPaths, rootNode, paths);

        List<String> rightPaths = binaryTreePaths(root.right);
        addPaths(rightPaths, rootNode, paths);

        if (paths.size() == 0) {
            paths.add(rootNode);
        }

        return paths;
    }

    private void addPaths(List<String> childrenPaths, String parent, List<String> paths) {
        for (String childrenPath : childrenPaths) {
            paths.add(parent + "->" + childrenPath);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        BinaryTreePaths_257 binaryTreePaths = new BinaryTreePaths_257();
        System.out.println(binaryTreePaths.binaryTreePaths(node1));

    }
}
