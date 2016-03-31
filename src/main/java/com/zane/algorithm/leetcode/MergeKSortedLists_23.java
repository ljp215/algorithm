package com.zane.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * <p>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 18:19
 */
public class MergeKSortedLists_23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> headerPriorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode header = null, node = null;

        for (ListNode listNode : lists) {
            if (listNode != null) {
                headerPriorityQueue.offer(listNode);
            }
        }

        while (!headerPriorityQueue.isEmpty()) {
            ListNode min = headerPriorityQueue.poll();

            if (node == null) {
                node = min;
                header = min;
            } else {
                node.next = min;
                node = node.next;
            }

            if (min.next != null) {
                headerPriorityQueue.offer(min.next);
            }
        }

        return header;
    }
}
