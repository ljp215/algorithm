package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: luojinping
 * Date: 17/5/14 上午8:08
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 * 
 * Find all the elements that appear twice in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * 
 * Output:
 * [2,3]
 */
public class Find_All_Duplicates_in_an_Array_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        Find_All_Duplicates_in_an_Array_442 findAllDuplicates =
                new Find_All_Duplicates_in_an_Array_442();

        System.out.println(findAllDuplicates.findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
