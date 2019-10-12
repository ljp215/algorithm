package com.zane.algorithm;

import com.zane.algorithm.model.Node;

/**
 * Author: luojinping
 * Date: 16/1/21
 * Time: 13:46
 */
public class LinkReverser {
    public static void main(String[] args) {
        Node header = create(10);

        print(header);

        Node newHeader = reverse(header);

        print(newHeader);

        header = create(10);

        newHeader = reverseTailHalf(header);

        print(newHeader);
    }

    private static Node create(int len) {
        if (len <= 0) {
            return null;
        }

        Node header = new Node(1, null);

        Node last = header;
        if (len >= 2) {
            for (int i = 2; i < len; i++) {
                Node node = new Node(i, null);
                last.next = node;
                last = node;
            }
        }

        return header;
    }

    private static Node reverse(final Node header) {
        Node current = header;
        Node next = null;
        Node newHeader = null;

        while (current != null) {
            next = current.next;
            current.next = newHeader;
            newHeader = current;
            current = next;
        }

        return newHeader;
    }

    private static Node reverseTailHalf(final Node header) {
        int linkLen = 0;
        Node current = header;
        while (current != null) {
            linkLen++;
            current = current.next;
        }

        Node pre = header;
        current = pre.next;
        int startIndex = 0;
        while (current != null) {
            startIndex++;
            if (startIndex == linkLen / 2) {
                break;
            }
            pre = current;
            current = current.next;
        }

        pre.next = reverse(current);

        return header;
    }

    private static void print(final Node header) {
        Node node = header;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
