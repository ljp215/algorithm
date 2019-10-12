package com.zane.algorithm.leetcode;

import java.util.Stack;

/**
 * Author: luojinping
 * Date: 16/3/22
 * Time: 13:51
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                char top = stack.peek();
                if (isMatch(top, ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char preCh, char postCh) {
        return (preCh == '(' && postCh == ')') ||
                (preCh == '[' && postCh == ']') ||
                (preCh == '{' && postCh == '}');

    }

    public static void main(String[] args) {
        ValidParentheses_20 validParentheses = new ValidParentheses_20();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("([)]"));
    }
}
