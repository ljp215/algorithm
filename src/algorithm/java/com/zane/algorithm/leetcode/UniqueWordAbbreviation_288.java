package main.com.zane.leetcode;

import java.util.*;

/**
 * Question
 * <p>
 * An abbreviation of a word follows the form . Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 * 1
 * b) d|o|g                   --> d1g
 * 1    1  1
 * 1---5----0----5--8    // it is one, five, ten, fifteen, and eighteen
 * c) i|nternationalizatio|n  --> i18n
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example: Given dictionary = [ "deer", "door", "cake", "card", "happy", "happy" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * isUnique("happy") -> true ! 这个很重要, 一开始我没有理解, 导致出错!
 * Idea
 * <p>
 * <p>
 * 题意: 即每一个单词都由首位2个字母加上中间的长度来形成一个缩写. 当然: 如果只有1或2位的单词的缩写就是本身.
 * Unique的意义是: 这个字典里的单词的缩写如果和这个单词一样的话, 那么全写也应该一样. 如果字典里面没有该缩写的话也是Unique.
 * <p>
 * Created by jinpiluo on 3/25/16.
 */
public class UniqueWordAbbreviation_288 {
    private String[] dictionary;
    private Map<String, Set<String>> abbrWordsMap;

    public UniqueWordAbbreviation_288(String[] dictionary) {
        this.dictionary = dictionary;
        this.abbrWordsMap = new HashMap<>();

        for (int i = 0; i < dictionary.length; i++) {
            String wordAbbr = getAbbr(dictionary[i]);
            Set<String> words = abbrWordsMap.get(wordAbbr);
            if (words == null) {
                words = new HashSet<>();
            }
            words.add(wordAbbr);
            abbrWordsMap.put(wordAbbr, words);
        }
    }

    public boolean isUnique(String word) {
        Set<String> words = abbrWordsMap.get(getAbbr(word));
        return words == null || words.contains(word);
    }

    private String getAbbr(String word) {
        int wordLen = word.length();
        if (wordLen <= 2) {
            return word;
        } else {
            return word.charAt(0) + String.valueOf(wordLen - 2) + word.charAt(wordLen - 1);
        }
    }
}
