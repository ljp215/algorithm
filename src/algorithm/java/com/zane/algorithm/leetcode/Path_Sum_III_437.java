package com.zane.algorithm.leetcode;

import com.zane.algorithm.model.TreeNode;
import com.zane.algorithm.utils.TreeUtils;

/**
 * Author: luojinping
 * Date: 17/5/21
 * Time: 10:19
 * <p>
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class Path_Sum_III_437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root, sum, true);
    }

    public int pathSum(TreeNode root, int sum, boolean noStartNode) {
        int result = 0;

        if (root == null) {
            return result;
        }

        if (root.val == sum) {
//            System.out.println("node=" + root + "\t sum=" + sum);
            result++;
        }

        if (noStartNode) {
            result += pathSum(root.left, sum, true);
            result += pathSum(root.right, sum, true);
        }

        result += pathSum(root.left, sum - root.val, false);
        result += pathSum(root.right, sum - root.val, false);

        return result;
    }

    public static void main(String[] args) {
        Path_Sum_III_437 pathSumIii = new Path_Sum_III_437();


        TreeNode root = TreeUtils.createBinTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2,
                null, 1});
        System.out.println(String.valueOf(pathSumIii.pathSum(root, 8)));


        TreeNode root2 = TreeUtils.createBinTree(new Integer[]{0, 0, null, 0, null, 0, null, 0,
                null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null, 0, null});

        System.out.println(String.valueOf(pathSumIii.pathSum(root2, 0)));
    }

}
