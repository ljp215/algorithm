package com.zane.algorithm;

/**
 * Author: luojinping
 * Date: 16/2/23
 * Time: 11:09
 */
public class QuickSort {
    /**
     * Lomuto partition scheme.
     * This scheme is attributed to Nico Lomuto and popularized by Bentley in his book
     * Programming Pearls
     *
     * @param nums
     */
    public void lomutoQuickSort(int[] nums) {
        lomutoQuickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void lomutoQuickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivot = lomutoPartition(nums, lo, hi);
            lomutoQuickSort(nums, lo, pivot - 1);
            lomutoQuickSort(nums, pivot + 1, hi);
        }
    }

    private int lomutoPartition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        // replace the guard element
        swap(nums, i, hi);
        return i;
    }


    /**
     * Hoare partition scheme.
     * The original partition scheme described by C.A.R. Hoare uses two indices that start at
     * the ends of the array being partitioned, then move toward each other, until they detect
     * an inversion
     *
     * Hoare's scheme is more efficient than Lomuto's partition scheme because it does three
     * times fewer swaps on average, and it creates efficient partitions even when all values
     * are equal.
     *
     * @param nums
     */
    public void hoareQuickSort(int[] nums) {
        hoareQuickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void hoareQuickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivot = hoarePartition(nums, lo, hi);
            hoareQuickSort(nums, lo, pivot);
            hoareQuickSort(nums, pivot + 1, hi);

        }
    }

    private int hoarePartition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        int i = lo, j = hi;
        while (true) {
            while (nums[i] < pivot) {
                i++;
            }

            while (nums[j] >= pivot) {
                j--;
            }

            if (i >= j) {
                return j;
            }

            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {8, 1, 3, 2, 5, 7, 6, 4};
        quickSort.lomutoQuickSort(nums);

        int[] nums2 = {8, 1, 3, 2, 5, 7, 6, 4};
        quickSort.hoareQuickSort(nums2);

    }
}
