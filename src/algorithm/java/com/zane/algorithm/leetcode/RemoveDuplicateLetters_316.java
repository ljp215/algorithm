package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 16/2/23
 * Time: 16:56
 * <p/>
 * Given a string which contains only lowercase letters, remove duplicate letters so that every
 * letter appear once and only once. You must make sure your result is the smallest  in
 * lexicographical order among all possible results.
 * Example:
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateLetters_316 {
    /**
     * After determining the greedy choice s[i], we get a new string s' from s by
     * removing all letters to the left of s[i],
     * removing all s[i]'s from s.
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters_316 removeDuplicateLetters = new RemoveDuplicateLetters_316();
        String s = "cbacdcbca";
        System.out.println(removeDuplicateLetters.removeDuplicateLetters(s));
    }
}
