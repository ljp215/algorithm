package com.zane.algorithm.leetcode;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Created by jinpiluo on 3/24/16.
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private Node head; // dummy "fence" head
    private Node tail; // dummy "fence" tail
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        promoteToHead(n);
        return n.val;
    }

    public void set(int key, int value) {
        Node n;
        // update existing Node; does not alter cache size
        if (map.containsKey(key)) {
            n = map.get(key);
            n.val = value;   // map.get(n.key) will now return node with new val
            promoteToHead(n);

            return;
        }
        if (map.size() == capacity) {
            Node last = tail.prev;
            map.remove(last.key);
            remove(last);
        }
        n = new Node(key, value);
        addFirst(n);
        map.put(key, n);
    }

    /**
     * Move given Node to head of queue.
     */
    private void promoteToHead(Node n) {
        if (head != n) {
            remove(n);
            addFirst(n);
        }
    }

    /**
     * Remove given Node from queue.
     */
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    /**
     * Insert given Node to head of queue.
     */
    private void addFirst(Node n) {
        // first insert looks like:
        //  -1 <-> -1
        //  -1 <-> n <-> -1
        Node temp = head.next;
        head.next = n;
        n.prev = head;
        n.next = temp;
        n.next.prev = n;
    }

    public void printCache() throws Exception {
        if (head.next == tail) {
            throw new Exception("empty cache!");
        }
        Node n = head.next;
        System.out.print("[ ");
        while (n != tail) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println("]");
    }

    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2, 1);
        System.out.println(lruCache.get(2));
        lruCache.set(3, 2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));

//        LRUCache lruCache = new LRUCache(3);
//        lruCache.set(1, 1);
//        lruCache.set(2, 2);
//        lruCache.set(3, 3);
//        lruCache.get(1);
//        lruCache.get(2);
//        lruCache.set(4, 4);
//        lruCache.get(4);
    }

}
