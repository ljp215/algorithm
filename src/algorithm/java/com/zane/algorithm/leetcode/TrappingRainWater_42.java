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

    public static void main(String[] args) {
        TrappingRainWater_42 trappingRainWater = new TrappingRainWater_42();
        System.out.println(trappingRainWater.trap(new int[] {0, 0, 0}));
        System.out.println(trappingRainWater.trap(new int[] {0, 1, 2}));
        System.out.println(trappingRainWater.trap(new int[] {2, 1, 2, 1}));
        System.out.println(trappingRainWater.trap(new int[] {2, 0, 0, 8, 0, 10}));
        System.out.println(trappingRainWater.trap(new int[] {0, 2, 0, 3, 1, 2, 0, 2, 1, 4, 2, 1}));
        System.out.println(trappingRainWater.trap(new int[] {0, 4, 6, 8, 1, 5, 7, 12, 2, 13, 2}));
    }
}
