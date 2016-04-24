package main.com.zane.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Created by jinpiluo on 4/1/16.
 */
public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, min = nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[low] || nums[mid] < nums[high]) {
                high = mid;
                min = nums[mid];
            } else {
                low = mid + 1;
                min = Math.min(nums[low], nums[high]);
            }
        }

        return min;
    }
}
