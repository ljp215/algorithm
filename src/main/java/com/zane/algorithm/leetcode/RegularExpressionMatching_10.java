package com.zane.algorithm.leetcode;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") // false
 * isMatch("aa","aa") // true
 * isMatch("aaa","aa") // false
 * isMatch("aa", "a*") // true
 * isMatch("aa", ".*") // true
 * isMatch("ab", ".*") // true
 * isMatch("aab", "c*a*b") // true
 * <p>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 11:32
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pCh1 = p.charAt(j - 1);

                if (pCh1 != '.' && pCh1 != '*') {
                    if (i > 0 && s.charAt(i - 1) == pCh1 && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    }
                } else if (pCh1 == '.') {
                    if (i > 0 && dp[i - 1][j - 1])
                        dp[i][j] = true;
                } else if (j > 1) {
                    char pCh2 = p.charAt(j - 2);

                    //'*' cannot be the 1st element
                    if (dp[i][j - 1] || dp[i][j - 2])
                        // match 0 or 1 preceding element
                        dp[i][j] = true;
                    else if (i > 0 && (pCh2 == s.charAt(i - 1) || pCh2 == '.') && dp[i - 1][j])
                        // match multiple preceding elements
                        dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching_10 regularExpMatching = new RegularExpressionMatching_10();

        isMatch(regularExpMatching, "aa", "a");//false
        isMatch(regularExpMatching, "aa", "aa");//true
        isMatch(regularExpMatching, "aaa", "aa");//false
        isMatch(regularExpMatching, "aa", "a*");//true
        isMatch(regularExpMatching, "aa", ".*");//true
        isMatch(regularExpMatching, "ab", ".*");//true
        isMatch(regularExpMatching, "aab", "c*a*b");//true
    }

    public static void isMatch(RegularExpressionMatching_10 regularExpMatching, String s, String p) {
        System.out.println(regularExpMatching.isMatch(s, p));
    }
}
