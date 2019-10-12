package com.zane.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: luojinping
 * Date: 16/2/29
 * Time: 10:41
 * <p/>
 * Given a string, find the length of the longest substring without repeating characters.  For
 * example, the longest substring without repeating letters for "abcabcbb" is "abc",  which the
 * length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeating_3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> subStringCharIndex = new HashMap<>();

        int maxSubLen = 0, subLen = 0;
        int i = 0;
        while (i < s.length()) {
            Integer index = subStringCharIndex.get(s.charAt(i));

            if (index != null) {
                subStringCharIndex.clear();
                subLen = 0;
                i = index + 1;
                continue;
            }

            subStringCharIndex.put(s.charAt(i), i);
            subLen++;
            maxSubLen = maxSubLen > subLen ? maxSubLen : subLen;
            i++;
        }

        return maxSubLen;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating_3 longestSub = new LongestSubstringWithoutRepeating_3();

        System.out.println(longestSub.lengthOfLongestSubstring("aaabcdbca"));
    }
}
