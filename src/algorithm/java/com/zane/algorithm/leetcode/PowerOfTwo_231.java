package main.com.zane.leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Created by jinpiluo on 3/29/16.
 */
public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }

        while (n / 2 != 0) {
            if (n % 2 > 0) {
                return false;
            } else {
                n /= 2;
            }
        }

        return true;
    }

    // Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
    public boolean isPowerOfTwoSimple(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }
}
