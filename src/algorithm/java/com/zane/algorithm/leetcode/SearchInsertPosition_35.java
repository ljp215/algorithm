package com.zane.algorithm.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p>
 * Author: luojinping
 * Date: 16/3/31
 * Time: 21:45
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int res = 0, low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
                res = mid + 1;
            } else if (target < nums[mid]) {
                high = mid-1;
                res = mid;
            } else {
                res = mid;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchInsertPosition_35 searchInsertPosition = new SearchInsertPosition_35();
        searchInsertPosition.searchInsert(new int[]{1}, 0);
    }
}
