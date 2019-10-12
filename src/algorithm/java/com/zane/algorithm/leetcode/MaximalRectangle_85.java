package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/23
 * Time: 上午11:53
 */
public class MaximalRectangle_85 {
    private LargestRectangleInHistogram_84 largestRectangleInHistogram84 =
            new LargestRectangleInHistogram_84();

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n;
        if (m == 0 || (n = matrix[0].length) == 0) {
            return 0;
        }

        int i, j, res = 0;
        int[] heights = new int[n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
            res = Math.max(res, largestRectangleInHistogram84.largestRectangleArea(heights));
        }

        return res;
    }

    public static void main(String[] args) {
        MaximalRectangle_85 maximalRectangle = new MaximalRectangle_85();

        char[][] matrix = new char[4][6];
        matrix[0] = new char[] {'1', '0', '1', '0', '0'};
        matrix[1] = new char[] {'1', '0', '1', '1', '1'};
        matrix[2] = new char[] {'1', '1', '1', '1', '1'};
        matrix[3] = new char[] {'1', '0', '0', '1', '0'};

        System.out.println(maximalRectangle.maximalRectangle(matrix));

        matrix = new char[2][1];
        matrix[0] = new char[] {'0'};
        matrix[1] = new char[] {'1'};

        System.out.println(maximalRectangle.maximalRectangle(matrix));


        matrix = new char[1][4];
        matrix[0] = new char[] {'1', '0', '1', '1'};

        System.out.println(maximalRectangle.maximalRectangle(matrix));

        matrix = new char[1][1];
        matrix[0] = new char[] {'0'};

        System.out.println(maximalRectangle.maximalRectangle(matrix));

        matrix = new char[6][6];
        matrix[0] = new char[] {'1', '0', '1', '0', '0'};
        matrix[1] = new char[] {'1', '0', '1', '1', '1'};
        matrix[2] = new char[] {'1', '1', '1', '1', '1'};
        matrix[3] = new char[] {'1', '0', '1', '1', '0'};
        matrix[4] = new char[] {'1', '0', '1', '1', '0'};
        matrix[5] = new char[] {'1', '0', '0', '1', '0'};

        System.out.println(maximalRectangle.maximalRectangle(matrix));
    }


}
