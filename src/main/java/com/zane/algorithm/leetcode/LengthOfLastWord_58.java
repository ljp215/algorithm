package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 15/5/21
 * Time: 上午11:11
 */
public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int lastSpaceIndex = s.length() - 1;
        while (lastSpaceIndex >= 0) {
            if (' ' == s.charAt(lastSpaceIndex)) {
                lastSpaceIndex++;
                break;
            }
            lastSpaceIndex--;
        }
        lastSpaceIndex = lastSpaceIndex >= 0 ? lastSpaceIndex : 0;
        return s.length() - lastSpaceIndex;
    }

    public static void main(String[] args) {
        LengthOfLastWord_58 lengthOfLastWord58 = new LengthOfLastWord_58();

        System.out.println(lengthOfLastWord58.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("HelloWorld"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("a"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("b a "));
        System.out.println(lengthOfLastWord58.lengthOfLastWord(" "));
        System.out.println(lengthOfLastWord58.lengthOfLastWord(""));
    }
}
