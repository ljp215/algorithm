package main.com.zane.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * <p>
 * Created by jinpiluo on 3/18/16.
 */
public class WildcardMatching44 {
    /**
     * The point is the if order, firstly match the same char, then consider the last p char whether a '*'
     * Example:
     * str: ababcbc
     * pattern: a*bc
     * <p>
     * ---------------------------------------------
     * str:           a  b  a  b  c  b   c
     * pattern:       a  *  b  c
     * ---------------------------------------------
     * s: 1	    p: 1	match: 0	starIdx: -1
     * s: 1	    p: 2	match: 1	starIdx: 1
     * s: 2	    p: 3	match: 1	starIdx: 1
     * s: 2	    p: 2	match: 2	starIdx: 1
     * s: 3	    p: 2	match: 3	starIdx: 1
     * s: 4	    p: 3	match: 3	starIdx: 1
     * s: 5	    p: 4	match: 3	starIdx: 1
     * s: 4	    p: 2	match: 4	starIdx: 1
     * s: 5	    p: 2	match: 5	starIdx: 1
     * s: 6	    p: 3	match: 5	starIdx: 1
     * s: 7	    p: 4	match: 5	starIdx: 1
     * ---------------------------------------------
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                // advancing both pointers
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                // * found, only advancing pattern pointer
                starIdx = p;
                match = s;
                p++;
            } else if (starIdx != -1) {
                // last pattern pointer was *, advancing string pointer
                p = starIdx + 1;
                match++;
                s = match;
            } else {
                //current pattern pointer is not star, last patter pointer was not *
                //characters do not match
                return false;
            }
            System.out.println("s: " + s + "\tp: " + p + "\tmatch: " + match + "\tstarIdx: " + starIdx);
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }


    public static void main(String[] args) {
        WildcardMatching44 wildcardMatching = new WildcardMatching44();

        // Test for TLE
        String s = "ababcbc";
        String p = "a*bc";
        System.out.println(wildcardMatching.isMatch(s, p));
    }
}