package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 16/3/27
 * Time: 10:47
 */
public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int i = 0, j = row_num * col_num - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int element = matrix[mid / col_num][mid % col_num];
            ;
            if (element == target) {
                return true;
            } else if (element > target) {
                j = mid - 1;
            } else {
                //Should move a bit further, otherwise dead loop.
                i = mid + 1;
            }
        }

        return false;
    }
}
