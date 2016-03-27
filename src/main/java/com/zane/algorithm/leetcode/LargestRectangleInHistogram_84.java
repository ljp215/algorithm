package com.zane.algorithm.leetcode;

import java.util.Stack;

/**
 * Author: luojinping
 * Date: 15/5/23
 * Time: 上午10:22
 * <p/>
 * Given n non-negative integers representing the histogram's bar height where the width of each
 * bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p/>
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleInHistogram_84 {
    // O(n^2), O(1)
    public int largestRectangleArea(int[] height) {
        int areaMax = 0, area = 0;
        for (int i = 0; i < height.length; i++) {
            area = height[i];
            for (int j = i + 1; j < height.length && height[j] > height[i]; j++) {
                area += height[i];
            }
            areaMax = area > areaMax ? area : areaMax;
        }

        return areaMax;
    }

    // O(n), O(n)
    public int largestRectangleArea2(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram_84 largestRectangleInHistogram84 = new LargestRectangleInHistogram_84();

        int[] height1 = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleInHistogram84.largestRectangleArea(height1));
    }

}
