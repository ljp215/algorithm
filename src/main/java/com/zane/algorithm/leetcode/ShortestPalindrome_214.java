package com.zane.algorithm.leetcode;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front
 * of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p/>
 * For example:
 * <p/>
 * Given "aacecaaa", return "aaacecaaa".
 * <p/>
 * Given "abcd", return "dcbabcd".
 * <p/>
 * Author: luojinping
 * Date: 16/3/22
 * Time: 16:53
 */
public class ShortestPalindrome_214 {
    // 其实就是找头部最长回文!
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s) {
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                //we can extend match in prefix and postfix
                table[i] = table[i - 1] + 1;
                index++;
            } else {
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the
                //prefix part that we used to match postfix ended at i - 1
                index = table[i - 1];

                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index - 1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if (s.charAt(index) == s.charAt(i)) {
                    //if match, then extend one char
                    index++;
                }

                table[i] = index;
            }

        }

        return table;
    }

    public static void main(String[] args) {
        ShortestPalindrome_214 shortestPalindrome = new ShortestPalindrome_214();
//        System.out.println(shortestPalindrome.shortestPalindrome("aacecaaa"));
//        System.out.println(shortestPalindrome.shortestPalindrome("abcd"));

        // expect: "abbaabba"
        System.out.println(shortestPalindrome.shortestPalindrome("aabba"));

        // expect: "ababbabbbababbbabbaba"
        System.out.println(shortestPalindrome.shortestPalindrome("ababbbabbaba"));
    }
}
