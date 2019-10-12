package com.zane.algorithm.leetcode;

import java.util.*;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.  Return
 * an empty list if no palindromic permutation could be form.
 * <p>
 * For example:
 * <p>
 * Given s = "aabb", return ["abba", "baab"].
 * <p>
 * Given s = "abc", return [].
 * <p>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 13:38
 */
public class PalindromePermutationII_267 {
    public List<String> getPalindromic(String s) {
        Map<Character, Integer> chCntMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer cntInt = chCntMap.get(s.charAt(i));
            if (cntInt == null) {
                cntInt = 0;
            }
            chCntMap.put(s.charAt(i), cntInt + 1);
        }

        char midCh = ' ';
        List<Character> frontChList = new ArrayList<>();
        for (Map.Entry<Character, Integer> chCnt : chCntMap.entrySet()) {
            char ch = chCnt.getKey();
            int cnt = chCnt.getValue();

            if (cnt % 2 == 1) {
                if (midCh != ' ') {
                    return new ArrayList<>();
                }

                midCh = ch;
                cnt--;
            }

            for (int i = 0; i < cnt / 2; i++) {
                frontChList.add(ch);
            }
        }

        Set<String> frontHalfStrs = generateArrange(frontChList.toArray(new Character[frontChList
                .size()]), 0);

        List<String> res = new ArrayList<>();

        for (String frontHalfStr : frontHalfStrs) {
            if (midCh == ' ') {
                res.add(frontHalfStr + reverse(frontHalfStr));
            } else {
                res.add(frontHalfStr + midCh + reverse(frontHalfStr));
            }
        }

        return res;
    }

    private String reverse(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            res += s.charAt(i);
        }

        return res;
    }

    // 全排列生成前半部分的String
    private Set<String> generateArrange(Character[] chList, int start) {
        Set<String> arrange = new HashSet<>();

        for (int i = start; i < chList.length; i++) {
            if (i > start) {
                swap(chList, start, i);
            }

            Set<String> nextGenerateArrange = generateArrange(chList, start + 1);
            if (nextGenerateArrange.size() == 0) {
                arrange.add(String.valueOf(chList[start]));
            } else {
                for (String str : nextGenerateArrange) {
                    arrange.add(chList[start] + str);
                }
            }

            if (i > start) {
                swap(chList, i, start);
            }
        }

        return arrange;
    }

    private void swap(Character[] chList, int i, int j) {
        char temp = chList[i];
        chList[i] = chList[j];
        chList[j] = temp;
    }

    public static void main(String[] args) {
        PalindromePermutationII_267 palindromePermutationII = new PalindromePermutationII_267();
        palindromePermutationII.getPalindromic("abba").forEach(System.out::println);
        System.out.println("==================");
        palindromePermutationII.getPalindromic("abeab").forEach(System.out::println);
        System.out.println("==================");
        palindromePermutationII.getPalindromic("abcabdc").forEach(System.out::println);
    }
}
