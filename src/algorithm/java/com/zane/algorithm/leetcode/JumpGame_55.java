package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 2018/1/26
 * Time: 22:51
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int j = 0;

        for (int i = 0; i <= j && i < nums.length; i++) {
            int progressMax = (i + nums[i]);

            if (progressMax >= nums.length - 1) {
                return true;
            }

            j = progressMax > j ? progressMax : j;
        }

        return false;
    }
}
