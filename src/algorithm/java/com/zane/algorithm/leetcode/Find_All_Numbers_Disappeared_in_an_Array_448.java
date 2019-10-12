package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: luojinping
 * Date: 17/5/14 上午11:55
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 * 
 * Example:
 * 
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [5,6]
 */
public class Find_All_Numbers_Disappeared_in_an_Array_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                continue;
            } else {
                nums[index] = -nums[index];
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Find_All_Numbers_Disappeared_in_an_Array_448 findAllNumbersDisappeared =
                new Find_All_Numbers_Disappeared_in_an_Array_448();

        System.out.println(findAllNumbersDisappeared
                .findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
