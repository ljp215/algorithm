package com.zane.algorithm.leetcode;

import java.util.Arrays;


/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to
 * compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at
 * least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of
 * them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3
 * citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 * <p>
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * Show Hint
 * <p>
 * Created by jinpiluo on 3/23/16.
 */
public class H_Index_274 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int minDiff = Math.abs(citations.length - 1 - citations[0]), minIndex = 0;
        for (int i = 0; i < citations.length; i++) {
            int diff = Math.abs(citations.length - i - 1 - citations[i]);
            if (diff <= minDiff) {
                minDiff = diff;
                minIndex = i;
            }
        }

        int largerCnt = citations.length - minIndex;

        if (citations[minIndex] < largerCnt) {
            largerCnt--;
        }

        return largerCnt;
    }

    public static void main(String[] args) {
        H_Index_274 h_index = new H_Index_274();

        int nums[] = new int[]{0, 3, 6, 1, 5};
        System.out.println(h_index.hIndex(nums));

        int nums2[] = new int[]{0, 1, 3, 50, 70, 80, 90};
        System.out.println(h_index.hIndex(nums2));

        int nums3[] = new int[]{0, 1, 5, 50, 70, 80, 90};
        System.out.println(h_index.hIndex(nums3));
    }
}
