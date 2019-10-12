package com.zane.algorithm.leetcode;


import java.util.Objects;
import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p/>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
 * non-negative integers and empty spaces .
 * <p/>
 * You may assume that the given expression is always valid.
 * <p/>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 * <p/>
 * <p/>
 * <p/>
 * Created by jinpiluo on 3/24/16.
 */
public class BasicCalculator_224 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> computeStack = new Stack<>();

        boolean topIsNum = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }

            if (ch >= '0' && ch <= '9') {
                int curInt = ch - '0';
                if (!stack.isEmpty() && topIsNum) {
                    curInt = Integer.valueOf(stack.pop()) * 10 + curInt;
                }
                stack.push(String.valueOf(curInt));
                topIsNum = true;
            } else {
                if (ch == '+' || ch == '-' || ch == '(') {
                    stack.push(String.valueOf(ch));
                    topIsNum = false;
                } else if (ch == ')') {
                    String top = stack.pop();
                    while (!Objects.equals(top, "(")) {
                        computeStack.push(top);
                        top = stack.pop();
                    }
                    int calculateResult = calculate(computeStack);
                    stack.push(String.valueOf(calculateResult));
                    topIsNum = true;
                }
            }
        }


        while (!stack.empty()) {
            computeStack.push(stack.pop());
        }

        return calculate(computeStack);
    }

    private int calculate(Stack<String> computeStack) {
        int result = Integer.parseInt(computeStack.pop());
        while (!computeStack.empty()) {
            String op = computeStack.pop();
            int num = Integer.parseInt(computeStack.pop());
            if (Objects.equals(op, "-")) {
                result -= num;
            } else if (Objects.equals(op, "+")) {
                result += num;
            }

        }

        return result;
    }

    public int calculateConcise(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0) result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator_224 basicCalculator = new BasicCalculator_224();
        System.out.println(basicCalculator.calculate(" 1+ 2  "));
        System.out.println(basicCalculator.calculate("1+2-4"));
        System.out.println(basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
