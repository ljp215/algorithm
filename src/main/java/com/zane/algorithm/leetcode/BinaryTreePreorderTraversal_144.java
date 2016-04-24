package main.com.zane.leetcode;

import main.com.zane.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * Created by jinpiluo on 3/31/16.
 */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrderIterate(root, res);
        return res;
    }

    private void preOrderIterate(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        res.add(node.val);
        preOrderIterate(node.left, res);
        preOrderIterate(node.right, res);
    }

    private void idOrderIterate(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        idOrderIterate(node.left, res);
        res.add(node.val);
        idOrderIterate(node.right, res);
    }
}
