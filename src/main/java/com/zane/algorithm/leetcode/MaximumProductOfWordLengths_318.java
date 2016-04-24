package main.com.zane.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do
 * not share common letters. You may assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * <p>
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * <p>
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * <p>
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 * Created by jinpiluo on 4/1/16.
 */
public class MaximumProductOfWordLengths_318 {
    /**
     * int has 32bits,but lower case letters only has 26.
     * we can use the lowest 26 bit of int indicates that the word has how many kinds of lower case letters.
     * If the lowest bit of int is 1,it indicates the word has lower case letter 'a'.
     * the order of lower case letter is from right to left,like zyx.....cba.
     * so value[i] indicates the condition of the word i having how many kinds of lower case letters.
     *
     * @param words
     * @return
     */
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];

        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductOfWordLengths_318 maximumProductOfWordLengths = new MaximumProductOfWordLengths_318();
        maximumProductOfWordLengths.maxProduct(new String[]{"abc", "ab", "ef"});
    }
}
