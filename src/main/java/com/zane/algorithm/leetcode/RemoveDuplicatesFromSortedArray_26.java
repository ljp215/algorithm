package main.com.zane.leetcode;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the
 * new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Created by jinpiluo on 3/29/16.
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        // id: the write index
        // i: current read index, if nums[i-1]==nums[i], duplicated
        int id = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[id++] = nums[i];
            }
        }

        return id;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_26 removeDuplicates = new RemoveDuplicatesFromSortedArray_26();

        int[] nums = new int[]{1, 1, 1, 2, 3, 4};

        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
}
