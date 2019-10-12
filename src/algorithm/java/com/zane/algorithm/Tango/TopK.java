package com.zane.algorithm.Tango;

import java.util.*;

/**
 * Author: luojinping
 * Date: 15/6/7
 * Time: 下午12:33
 */

public class TopK {

    //固定容量的优先队列，模拟大顶堆，用于解决求topN小的问题
    public static class FixSizedPriorityQueue<E extends Comparable> {
        private PriorityQueue<E> queue;
        private int maxSize; // 堆的最大容量

        public FixSizedPriorityQueue(int maxSize) {
            if (maxSize <= 0)
                throw new IllegalArgumentException();
            this.maxSize = maxSize;
            this.queue = new PriorityQueue(maxSize, new Comparator<E>() {
                public int compare(E o1, E o2) {
                    // 生成最大堆使用o2-o1,生成最小堆使用o1-o2, 并修改 e.compareTo(peek) 比较规则
                    return (o2.compareTo(o1));
                }
            });
        }

        public void add(E e) {
            if (queue.size() < maxSize) { // 未达到最大容量，直接添加
                queue.add(e);
            } else { // 队列已满
                E peek = queue.peek();
                if (e.compareTo(peek) < 0) { // 将新元素与当前堆顶元素比较，保留较小的元素
                    queue.poll();
                    queue.add(e);
                }
            }
        }

        public List<E> sortedList() {
            List<E> list = new ArrayList<E>(queue);
            Collections.sort(list); // PriorityQueue本身的遍历是无序的，最终需要对队列中的元素进行排序
            return list;
        }
    }

    public static void main(String[] args) {
        final FixSizedPriorityQueue pq = new FixSizedPriorityQueue(10);
        Random random = new Random();
        int rNum = 0;
        System.out.println("100 个 0~999 之间的随机数：-----------------------------------");
        for (int i = 1; i <= 100; i++) {
            rNum = random.nextInt(1000);
            System.out.println(rNum);
            pq.add(rNum);
        }
        System.out.println("PriorityQueue 本身的遍历是无序的：-----------------------------------");
        Iterable<Integer> iter = new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return pq.queue.iterator();
            }
        };
        for (Integer item : iter) {
            System.out.print(item + ", ");
        }
        System.out.println();
        System.out.println("PriorityQueue 排序后的遍历：-----------------------------------");
        /*
         * for (Integer item : pq.sortedList()) { System.out.println(item); }
         */
        // 或者直接用内置的 poll() 方法，每次取队首元素（堆顶的最大值）
        while (!pq.queue.isEmpty()) {
            System.out.print(pq.queue.poll() + ", ");
        }
    }
}