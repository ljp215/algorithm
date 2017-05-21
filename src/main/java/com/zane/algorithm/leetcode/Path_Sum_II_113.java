package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.zane.algorithm.leetcode.BinarySearchTreeIterator_173.TreeNode;

/**
 * Author: luojinping
 * Date: 17/5/21
 * Time: 09:46
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Path_Sum_II_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        pathSum(root, sum, result, new ArrayList<>());

        return result;
    }


    public void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer>
            currentPath) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> validPath = new ArrayList<>();
                validPath.addAll(currentPath);

                validPath.add(root.val);
                result.add(validPath);
            }
            return;
        }

        currentPath.add(root.val);

        if (root.left != null) {
            pathSum(root.left, sum - root.val, result, currentPath);
        }

        if (root.right != null) {
            pathSum(root.right, sum - root.val, result, currentPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }

}
