package com.zane.algorithm.leetcode;

import java.util.Arrays;

/**
 * Author: luojinping
 * Date: 15/5/21
 * Time: 下午1:53
 * <p/>
 * You are a professional robber planning to rob houses along a street.Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber_198 {

    // Time Limit Exceeded
    public int robRecursiveDP(int[] nums, int length) {
        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int rob1 = robRecursiveDP(nums, length - 1);
        int rob2 = robRecursiveDP(nums, length - 2);

        if (rob1 == rob2) {
            return rob1 + nums[length - 1];
        } else if (rob1 > rob2) {
            return Math.max(rob2 + nums[length - 1], rob1);
        } else {
            System.out.println("data error");
            return 0;
        }
    }

    // 300ms
    public int robDP(int[] nums) {
        // dp[i][1] means we rob the current house and dp[i][0] means we don't
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    // 250ms
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }

    public int robCycle(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                rob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public static void main(String[] args) {
        HouseRobber_198 houseRobber = new HouseRobber_198();
        int[] nums1 = {5};
        System.out.println(houseRobber.rob(nums1));

        int[] nums2 = {5, 9, 8};
        System.out.println(houseRobber.rob(nums2));

        int[] nums3 = {5, 9, 8, 6};
        System.out.println(houseRobber.rob(nums3));

        int[] nums4 = {5, 9, 8, 6, 2, 1};
        System.out.println(houseRobber.rob(nums4));

        int[] nums5 = {183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66,
                90, 238, 168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135,
                62, 228, 247, 211};
        System.out.println(houseRobber.rob(nums5));

        int[] nums6 = {1, 1};
        System.out.println(houseRobber.robCycle(nums6));

        int[] nums7 = {1, 1, 1, 1};
        System.out.println(houseRobber.robCycle(nums7));
    }
}
