package com.zane.algorithm.utils;

import java.util.LinkedList;
import java.util.List;

import com.zane.algorithm.model.TreeNode;

/**
 * Author: luojinping
 * Date: 17/5/21
 * Time: 10:39
 */
public class TreeUtils {
    public static TreeNode createBinTree(Integer[] array) {
        List<TreeNode> nodeList = new LinkedList<>();

        // 将一个数组的值依次转换为Node节点
        for (Integer anArray : array) {
            if (anArray == null) {
                nodeList.add(null);
            } else {
                nodeList.add(new TreeNode(anArray));
            }
        }

        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            if (nodeList.get(parentIndex) != null) {
                // 左孩子
                nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
                // 右孩子
                nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
            }
        }

        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;

        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);

        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
        }

        return nodeList.get(0);
    }

    public static void main(String[] args) {
        TreeNode root = createBinTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, null, 8, 9});
        System.out.printf(root.toString());
    }
}
