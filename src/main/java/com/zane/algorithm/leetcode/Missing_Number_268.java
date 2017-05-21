package com.zane.algorithm.leetcode;

/**
 * Author: luojinping@gotokeep.com
 * Date: 17/5/14 上午10:02
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is
 * missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant extra space complexity?
 */
public class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        return (nums.length * (nums.length + 1)) / 2 - sum;
    }
}
