package main.com.zane.leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * <p>
 * Created by jinpiluo on 3/29/16.
 */
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int res = 0;
        while (y != 0) {
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }

    public static void main(String[] args) {
        PalindromeNumber_9 palindromeNumber = new PalindromeNumber_9();
        System.out.println(palindromeNumber.isPalindrome(11));
        System.out.println(palindromeNumber.isPalindrome(1001));
    }
}
