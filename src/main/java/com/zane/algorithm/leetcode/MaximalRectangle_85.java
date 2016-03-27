package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/23
 * Time: 上午11:53
 */
public class MaximalRectangle_85 {
    private LargestRectangleInHistogram_84 largestRectangleInHistogram84 = new
            LargestRectangleInHistogram_84();

    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];
        //actually we know that height can just be a int[n+1],
        //however, in that case, we have to write the 2 parts together in row traverse,
        //which, leetcode just doesn't make you pass big set
        //所以啊，leetcode是喜欢分开写循环的，即使时间复杂度一样，即使可以节约空间
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int area = largestRectangleInHistogram84.largestRectangleArea(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
