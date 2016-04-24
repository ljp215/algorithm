package main.com.zane.leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 * <p>
 * Created by jinpiluo on 3/29/16.
 */
public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        int count = 0;
        int power = 1;

        while (true) {
            int fiveCnt = (int) (n / Math.pow(5, power));

            if (fiveCnt > 0) {
                count += fiveCnt;
                power += 1;
            } else {
                break;
            }

        }

        return count;
    }

    public int trailingZeroesSimple(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}
