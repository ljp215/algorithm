package main.com.zane.leetcode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * Credits:
 * <p>
 * Created by jinpiluo on 3/24/16.
 */
public class BinarySearchTreeIterator_173 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode root;

    public BinarySearchTreeIterator_173(TreeNode root) {
        this.root = root;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return root != null;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = root, preNode = null;
        if (node == null) {
            return -1;
        }

        while (node.left != null) {
            preNode = node;
            node = node.left;
        }

        int result = node.val;

        if (node == root && root.right == null) {
            root = null;
        } else {
            if (node.right != null) {
                if (preNode == null) {
                    root = node.right;
                } else {
                    preNode.left = node.right;
                }
            } else {
                if (preNode != null) {
                    preNode.left = null;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
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

        BinarySearchTreeIterator_173 binarySearchTreeIterator = new BinarySearchTreeIterator_173(node1);
        while (binarySearchTreeIterator.hasNext()) {
            System.out.println(binarySearchTreeIterator.next());
        }
    }
}
