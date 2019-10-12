package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/9/23
 * Time: 17:23
 * <p/>
 * <p/>
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 */
public class PerfectSquares_279 {
    /**
     * cannot use greedy algorithm, counter example：
     * 98=81+16+1=49+49
     * 101=100+1=49+1+49+2
     * 7=4+1+1+1
     * 12=4+4+4=9+1+1+1
     * 思路:
     * 使用DP, dp[]数组记录历史使用最少平方数的情况.例如dp[5]=2,记录的是使用最少(1+4)平方数的数量,即2.
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n <= 2) {
            return n;
        }

        // record the least number of perfect numbers when index = i
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            int leastNum = i;

            for (int j = 1; j * j <= i; j++) {
                leastNum = Math.min(leastNum, dp[i - j * j] + 1);

            }
            dp[i] = leastNum;
        }

        return dp[n];
    }


    private boolean isSquare(int n) {
        int sqrt_n = (int) (Math.sqrt(n));
        return (sqrt_n * sqrt_n == n);
    }

    /**
     * Legendre's three-square theorem:
     * The three squares theorem tells you that a positive integer n can be represented as the sum
     * of 3 squares (n = x^2 + y^2 + z^2) if and only if it is not of the form n = 4^a * (8 * b+7)
     * <p/>
     * Lagrange's four-square theorem:
     * Every natural number can be represented as the sum of four integer squares:
     * n= a^2 + b^2 + c^2 + d^2
     * <p/>
     * <p/>
     * So the are only 4 possible results: 1, 2, 3, 4.
     * <p/>
     * Refer:
     * https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics
     */
    public int numSquaresByMath(int n) {
        // If n is a perfect square, return 1.
        if (isSquare(n)) {
            return 1;
        }

        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while ((n & 3) == 0) // n%4 == 0
        {
            n >>= 2;
        }
        if ((n & 7) == 7) // n%8 == 7
        {
            return 4;
        }

        // Check whether 2 is the result.
        int sqrt_n = (int) (Math.sqrt(n));
        for (int i = 1; i <= sqrt_n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    public static void main(String[] args) {
        PerfectSquares_279 perfectSquares279 = new PerfectSquares_279();
        System.out.println(perfectSquares279.numSquares(4));
        System.out.println(perfectSquares279.numSquares(7));
        System.out.println(perfectSquares279.numSquares(12));
        System.out.println(perfectSquares279.numSquares(61));
        System.out.println(perfectSquares279.numSquares(100));
        System.out.println(perfectSquares279.numSquares(101));
    }
}
