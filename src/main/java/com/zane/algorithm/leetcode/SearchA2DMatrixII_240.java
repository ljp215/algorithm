package com.zane.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has
 * the following properties:
 * <p/>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p/>
 * Given target = 20, return false.
 * <p/>
 * <p/>
 * <p/>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 11:05
 */
public class SearchA2DMatrixII_240 {
    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            return this.x == ((Point) o).x && this.y == ((Point) o).y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        Set<Point> visited = new HashSet<Point>();

        return search(matrix, target, 0, 0, visited);
    }

    private boolean search(int[][] matrix, int target, int x, int y, Set<Point> visited) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        if (x > row_num - 1 || y > col_num - 1) {
            return false;
        }

        if (visited.contains(new Point(x, y))) {
            return false;
        } else {
            visited.add(new Point(x, y));
        }

        if (matrix[x][y] > target) {
            return false;
        } else if (matrix[x][y] < target) {
            return search(matrix, target, x + 1, y, visited) || search(matrix, target, x, y + 1,
                    visited);
        } else {
            return true;
        }
    }

    /**
     * We start search the matrix from top right corner, initialize the current position to top
     * right corner, if the target is greater than the value in current position, then the target
     * can not be in entire row of current position because the row is sorted, if the target is
     * less than the value in current position, then the target can not in the entire column
     * because the column is sorted too. We can rule out one row or one column each time, so the
     * time complexity is O(m+n).
     * <p/>
     * Refer:
     * https://leetcode.com/discuss/48852/my-concise-o-m-n-java-solution
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixSimple(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        // start from the top right corner
        int row = 0, col = matrix[0].length - 1;

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
