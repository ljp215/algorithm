package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 2018/1/27
 * Time: 11:37
 */
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int a = 0;
        int b = height.length - 1;
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (a <= b) {
            leftMax = Math.max(leftMax, height[a]);
            rightMax = Math.max(rightMax, height[b]);
            if (leftMax < rightMax) {
                // leftMax is smaller than rightMax, so the (leftMax-A[a]) water can be stored
                max += (leftMax - height[a]);
                a++;
            } else {
                max += (rightMax - height[b]);
                b--;
            }
        }
        return max;
    }
}
