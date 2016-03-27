package main.com.zane.leetcode;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Created by jinpiluo on 3/25/16.
 */
public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // find the Min{diff of two num}, so confirm the indexes of two arrays

        int low1 = 0, high1 = nums1.length - 1, low2 = 0, high2 = nums2.length - 1;
        int mid1 = low1 + (high1 - low1) / 2;
        int mid2 = low2 + (high2 - low2) / 2;
        int minDiff = Math.abs(nums1[mid1] - nums2[mid2]);
        int median = nums1[mid1] + (nums2[mid2] - nums1[mid1]) / 2;

        while (true) {
            if (nums1[mid1] > nums2[mid2]) {
                mid1 = low1 + (mid1 - low1) / 2;
                mid2 = mid2 + (high2 - mid2) / 2;
            } else {
                mid1 = mid1 + (high1 - mid1) / 2;
                mid2 = low2 + (mid2 - low2) / 2;
            }

            int newDiff = Math.abs(nums1[mid1] - nums2[mid2]);
            if (minDiff <= newDiff) {
                break;
            } else {
                minDiff = newDiff;
                median = nums1[mid1] + (nums2[mid2] - nums1[mid1]) / 2;
            }
        }

        return median;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_4 medianOfTwoSortedArrays = new MedianOfTwoSortedArrays_4();
        int[] nums1 = new int[]{4, 8, 11, 19, 20};
        int[] nums2 = new int[]{1, 5, 6, 7, 9};
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }
}
