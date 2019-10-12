package com.zane.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * <p>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 13:34
 */
public class PalindromePermutation_266 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> charCnt = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charCnt.contains(ch)) {
                charCnt.remove(ch);
            } else {
                charCnt.add(ch);
            }
        }

        return charCnt.size() < 2;
    }
}
