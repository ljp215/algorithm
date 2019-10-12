package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/25
 * Time: 下午11:34
 * <p/>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p/>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p/>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString_97 {
    public boolean isInterleaveRecursiveDP(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        } else if (s3.length() == 0) {
            return false;
        }

        String newS3 = s3.substring(0, s3.length() - 1);
        String newS1 = s1.length() > 0 ? s1.substring(0, s1.length() - 1) : "";
        String newS2 = s2.length() > 0 ? s2.substring(0, s2.length() - 1) : "";

        boolean equalS1 = s1.length() > 0 && (s1.charAt(s1.length() - 1) == s3.charAt(s3.length() -
                1));
        boolean equalS2 = s2.length() > 0 && s2.charAt(s2.length() - 1) == s3.charAt(s3.length() -
                1);

        if (equalS1 && !equalS2) {
            return isInterleaveRecursiveDP(newS1, s2, newS3);
        } else if (!equalS1 && equalS2) {
            return isInterleaveRecursiveDP(s1, newS2, newS3);
        } else if (equalS1 && equalS2) {
            return isInterleaveRecursiveDP(newS1, s2, newS3) || isInterleaveRecursiveDP(s1, newS2, newS3);
        } else {
            return false;
        }
    }

    public boolean isInterleaveDP(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;

        boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++)
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0)
                    table[i][j] = true;
                else if (i == 0)
                    table[i][j] = (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                else if (j == 0)
                    table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                else
                    table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ||
                            (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }

        return table[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString_97 interleavingString = new InterleavingString_97();
        String s1 = "aabcc";
        String s2 = "dbbca";
        System.out.println(interleavingString.isInterleaveDP(s1, s2, "aadbbcbcac"));
        System.out.println(interleavingString.isInterleaveDP(s1, s2, "aadbbbaccc"));
        System.out.println(interleavingString.isInterleaveDP(s1, s2, "aadbbbacccd"));

        String s3 = "baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaabbbbabbbababbaaaabab";
        String s4 = "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababbaaaababaababbbbabbbbb";
        String s5 = "babbabbabbababbaaababbbbaababbaabbbbabbbbbaaabbabaababaabaaabaabbbaaaabbabbaaaaabbabbaabaaaabbbbababbbababbabaabababbababaaaaaabbababaaabbaabbbbaaaaabbbaaabbbabbbbaaabaababbaabababbbbababbaaabbbabbbab";
        System.out.println(interleavingString.isInterleaveDP(s3, s4, s5));
    }
}
