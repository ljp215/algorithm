package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 2018/1/25
 * Time: 23:28
 */
public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        while (start <= end) {
            int mid = (start + end + 1) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            boolean leftInAscendingOrder = nums[mid] >= nums[start];

            if (leftInAscendingOrder) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            } else {
                // right sub array in ascending order
                if (target >= nums[start] || target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray_33 search = new SearchInRotatedSortedArray_33();

        int index = search.search(new int[]{1, 1, 3}, 3);
        System.out.println(String.valueOf(index));

        index = search.search(new int[]{1, 3}, 3);
        System.out.println(String.valueOf(index));

        index = search.search(new int[]{4, 5, 6, 7, 1, 2, 3}, 1);
        System.out.println(String.valueOf(index));

        index = search.search(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 1);
        System.out.println(String.valueOf(index));
    }
}
