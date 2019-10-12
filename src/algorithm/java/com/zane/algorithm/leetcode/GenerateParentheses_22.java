package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * <p>
 * Created by jinpiluo on 3/23/16.
 */
public class GenerateParentheses_22 {

    /**
     * f(0): ""
     * f(1): "("f(0)")"
     * f(2): "("f(0)")"f(1), "("f(1)")"
     * f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"
     * So f(n) = "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "(f(n-1)")"
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesisDP(int n) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();

            for (int j = 0; j < i; ++j) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j)) {
                        list.add("(" + first + ")" + second);
                    }
                }
            }

            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }

    public List<String> generateParenthesisBacktrack(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        // 这里的顺序很关键,先增加(,然后在close<open的情况下增加),保证了最后str的合法性.
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}
