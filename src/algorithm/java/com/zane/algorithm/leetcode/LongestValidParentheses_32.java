package com.zane.algorithm.leetcode;

import java.util.Stack;

/**
 * Author: luojinping
 * Date: 16/3/22
 * Time: 14:22
 */
public class LongestValidParentheses_32 {
    /**
     * no need a stack to save the character
     * if '(' then push, else pop and compute valid length
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> idxStack = new Stack<>();

        int idxValidLen[] = new int[s.length()];
        int maxValidLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                idxStack.push(i);
            } else {
                if (idxStack.isEmpty()) {
                    continue;
                }

                int leftIdx = idxStack.pop();

                int curValidLen = i - leftIdx + 1;
                if (leftIdx > 0) {
                    curValidLen += idxValidLen[leftIdx - 1];
                }

                idxValidLen[i] = curValidLen;
                maxValidLen = maxValidLen > curValidLen ? maxValidLen : curValidLen;
            }
        }
        return maxValidLen;
    }

    /**
     * use a left cursor to record the last valid index,
     * includes matched left and not matched right
     * <p/>
     * reference:
     * <a href="https://leetcode.com/discuss/21549/simple-java-solution-o-n-time-one-stack">
     * simple java solution O(n) time one stack</a>
     *
     * @param s
     * @return
     */
    public int simpleLongestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '(') stack.push(j);
            else {
                if (stack.isEmpty()) left = j;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, j - left);
                    else max = Math.max(max, j - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses_32 longestValidParentheses = new LongestValidParentheses_32();
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
    }
}
