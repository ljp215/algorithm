package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 16/3/27
 * Time: 13:31
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}
