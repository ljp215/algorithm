package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: luojinping
 * Date: 16/3/22
 * Time: 16:22
 */
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        int start = 0, last = 0, end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[end] == 1) {
                end = i;
            } else {
                if (end > start) {
                    res.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
                } else {
                    res.add(String.valueOf(nums[start]));
                }
                start = i;
                end = i;
            }
        }

        if (end > start) {
            res.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
        } else {
            res.add(String.valueOf(nums[start]));
        }

        return res;
    }

    public static void main(String[] args) {
        SummaryRanges_228 summaryRanges = new SummaryRanges_228();
        int nums[] = new int[]{0, 1, 2, 4, 5, 7};
        summaryRanges.summaryRanges(nums).forEach(System.out::println);

        int nums2[] = new int[]{0, 8, 9};
        summaryRanges.summaryRanges(nums2).forEach(System.out::println);
    }
}
