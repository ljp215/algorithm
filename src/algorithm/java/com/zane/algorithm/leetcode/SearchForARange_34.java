package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 2018/1/26
 * Time: 22:38
 */
public class SearchForARange_34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            if (target > nums[start]) {
                start++;
            } else if (target < nums[start]) {
                break;
            }

            if (target < nums[end]) {
                end--;
            } else if (target > nums[end]) {
                break;
            }

            if (target == nums[start] && target == nums[end]) {
                return new int[]{start, end};
            }
        }

        return new int[]{-1, -1};
    }
}
