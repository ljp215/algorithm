package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 17/5/14 上午9:32
 *
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class First_Missing_Positive_41 {
    public int firstMissingPositive(int[] nums) {
        int firstPositiveNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                firstPositiveNum = nums[i];
                break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = firstPositiveNum;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int index = Math.abs(nums[i]) - 1;

            if (index >= nums.length) {
                continue;
            }

            if (nums[index] < 0) {
                continue;
            } else {
                nums[index] = -nums[index];
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                res++;
            } else {
                break;
            }
        }

        return res + 1;
    }

    public int firstMissingPositiveOfficial(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length)
                i++;
            else if (A[A[i] - 1] != A[i])
                swap(A, i, A[i] - 1);
            else
                i++;
        }
        i = 0;
        while (i < A.length && A[i] == i + 1)
            i++;
        return i + 1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        First_Missing_Positive_41 firstMissingPositive = new First_Missing_Positive_41();

        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {2}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(firstMissingPositive.firstMissingPositive(new int[] {3, 4, -1, 1}));
    }

}
