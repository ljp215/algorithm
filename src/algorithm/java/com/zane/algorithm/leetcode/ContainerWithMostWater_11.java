package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 2018/1/26
 * Time: 22:28
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;

        int maxArea = 0;
        while (start < end) {
            int containerHeight = height[start] < height[end] ? height[start] : height[end];
            int area = containerHeight * (end - start);
            maxArea = area > maxArea ? area : maxArea;

            if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
        }

        return maxArea;
    }
}
