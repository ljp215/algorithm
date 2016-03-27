package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 16/2/23
 * Time: 11:00
 * <p/>
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in
 * the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 */
public class KthLargestElement_215 {
    public int findKthLargest(int[] nums, int k) {
        k -= 1;
        int pivot = 0, lo = 0, hi = nums.length - 1;

        while (true) {
            pivot = partition(nums, lo, hi);

            if (pivot > k) {
                hi = pivot - 1;
            } else if (pivot < k) {
                lo = pivot + 1;
            } else {
                return nums[pivot];
            }
        }
    }

    private int partition(int nums[], int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi;
        while (i < j) {
            while (i < hi && nums[i] >= pivot) { // must contains the equal case
                i++;
            }

            while (j > lo && nums[j] < pivot) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, lo, j);  // replace the guard element
        return j;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement_215 kthLargestElement = new KthLargestElement_215();

        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(kthLargestElement.findKthLargest(nums, 2));

        int[] nums2 = {-1, 2, 0};
        System.out.println(kthLargestElement.findKthLargest(nums2, 1));

        int[] nums3 = {-1, -1};
        System.out.println(kthLargestElement.findKthLargest(nums3, 2));

        int[] nums4 = {2, 1};
        System.out.println(kthLargestElement.findKthLargest(nums4, 2));
    }
}
