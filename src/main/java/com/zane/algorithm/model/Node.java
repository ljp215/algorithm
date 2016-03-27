package com.zane.algorithm.model;

/**
 * Author: luojinping
 * Date: 16/1/21
 * Time: 13:50
 */
public class Node {

    public Object data;
    public Node next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(Object x) {
        data = x;
        next = null;
    }

    public Node(Object x, Node nextNode) {
        data = x;
        next = nextNode;
    }
}