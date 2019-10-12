package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/22
 * Time: 下午11:28
 * <p/>
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 * <p/>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has
 * the largest sum = 6.
 */
public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int sumMax = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                sum = num;
            }
            if (sum >= sumMax) {
                sumMax = sum;
            }
        }

        return sumMax;
    }

    public int maxSubArrayDP(int[] nums) {
        int sumMax = nums[0];
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            sumMax = Math.max(sumMax, dp[i]);
        }

        return sumMax;
    }

    public int maxSubArrayDPWithMem(int[] nums) {
        int sumMax = nums[0], sumPre = 0;
        for (int i = 1; i <= nums.length; i++) {
            sumPre = Math.max(sumPre + nums[i - 1], nums[i - 1]);
            sumMax = Math.max(sumMax, sumPre);
        }

        return sumMax;
    }


    public static void main(String[] args) {
        MaximumSubarray_53 maximumSubarray53 = new MaximumSubarray_53();
        int[] nums1 = {-1};
        System.out.println(maximumSubarray53.maxSubArrayDPWithMem(nums1));

        int[] nums2 = {1, -1, 1};
        System.out.println(maximumSubarray53.maxSubArrayDPWithMem(nums2));
    }
}
