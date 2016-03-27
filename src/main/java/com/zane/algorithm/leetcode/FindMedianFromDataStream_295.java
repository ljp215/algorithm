package main.com.zane.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * <p>
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * For example:
 * <p>
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3)
 * findMedian() -> 2
 * <p>
 * <p>
 * Created by jinpiluo on 3/24/16.
 */
public class FindMedianFromDataStream_295 {
    // PriorityQueue的内部实现就是最大(小)堆
    Queue<Integer> min = new PriorityQueue<>();//最小堆, 存放的是较大值
    Queue<Integer> max = new PriorityQueue(Collections.reverseOrder()); //最大堆, 存放的是较小值

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }

    // Returns the median of current data stream
    public void printQueues() {
        int nums1[] = new int[min.size()];
        int i = 0;
        System.out.print("min: ");
        while (!min.isEmpty()) {
            int temp = min.poll();
            nums1[i++] = temp;
            System.out.print(temp + " ");
        }
        System.out.println();

        for (int x = 0; x < nums1.length; x++) {
            min.offer(nums1[x]);
        }

        int nums2[] = new int[max.size()];
        int j = 0;
        System.out.print("max: ");
        while (!max.isEmpty()) {
            int temp = max.poll();
            nums2[j++] = temp;
            System.out.print(temp + " ");

        }
        System.out.println();

        for (int y = 0; y < nums2.length; y++) {
            max.offer(nums2[y]);
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream_295 findMedianFromDataStream = new FindMedianFromDataStream_295();
        findMedianFromDataStream.addNum(1);
        findMedianFromDataStream.printQueues();

        findMedianFromDataStream.addNum(2);
        findMedianFromDataStream.printQueues();

        findMedianFromDataStream.addNum(3);
        findMedianFromDataStream.printQueues();

        findMedianFromDataStream.addNum(4);
        findMedianFromDataStream.printQueues();

        findMedianFromDataStream.addNum(5);
        findMedianFromDataStream.printQueues();

        // min: 4 5 6
        // max: 3 2 1
        findMedianFromDataStream.addNum(6);
        findMedianFromDataStream.printQueues();

    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
