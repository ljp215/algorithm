package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/21
 * Time: 上午11:39
 * <p/>
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements_203 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head, currNode = head, lastNode = null, nextNode = null;
        while (currNode != null) {
            nextNode = currNode.next;
            if (currNode.val == val) {
                if (lastNode != null) {
                    lastNode.next = nextNode;
                } else {
                    newHead = nextNode;
                }
            } else {
                lastNode = currNode;
            }
            currNode = nextNode;
        }

        return newHead;
    }

    // another easy way
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
