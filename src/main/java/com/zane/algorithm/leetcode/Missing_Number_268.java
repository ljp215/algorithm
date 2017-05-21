package com.zane.algorithm.leetcode;

/**
 * Author: luojinping@gotokeep.com
 * Date: 17/5/14 上午10:02
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is
 * missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant extra space complexity?
 */
public class Missing_Number_268 {
    public int missingNumber(int[] nums) {
        int fullNumSum = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            fullNumSum += i;
            sum += nums[i];
        }

        return fullNumSum - sum;
    }


    public static void main(String[] args) {

    }
}
