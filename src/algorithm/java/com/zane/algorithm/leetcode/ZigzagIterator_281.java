package com.zane.algorithm.leetcode;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p/>
 * For example, given two 1d vectors:
 * <p/>
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by
 * next should be: [1, 3, 2, 4, 5, 6].
 * <p/>
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * Author: luojinping
 * Date: 16/3/26
 * Time: 18:49
 */
public class ZigzagIterator_281 {

    public int[] zigzagIterate(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length) {
                res[k++] = nums1[i++];
            }

            if (j < nums2.length) {
                res[k++] = nums2[j++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ZigzagIterator_281 zigzagIterator = new ZigzagIterator_281();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4, 5, 6};
        int[] res = zigzagIterator.zigzagIterate(nums1, nums2);
        for (int i : res) {
            System.out.print(i + ", ");
        }
    }
}
