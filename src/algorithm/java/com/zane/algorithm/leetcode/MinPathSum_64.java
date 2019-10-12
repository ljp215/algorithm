package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/23
 * Time: 上午8:21
 */
public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            minSum[i][1] = minSum[i - 1][1] + grid[i - 1][0];
        }

        for (int j = 1; j <= n; j++) {
            minSum[1][j] = minSum[1][j - 1] + grid[0][j - 1];
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i-1][j-1];
            }
        }

        return minSum[m][n];
    }

    public static void main(String[] args) {
        MinPathSum_64 minPathSum64 = new MinPathSum_64();
        int[][] nums1 = {{1, 3, 1}, {2, 5, 2}, {4, 6, 1}};
        System.out.println(minPathSum64.minPathSum(nums1));
    }
}
