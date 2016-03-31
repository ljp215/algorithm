package com.zane.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * <p>
 * Created by jinpiluo on 3/24/16.
 */
public class FractionToRecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integral part
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part
        res.append(".");

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal_166 fractionToRecurringDecimal = new FractionToRecurringDecimal_166();
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(1, 8));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(2, 3));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(4, 2));
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(1, 99));
    }
}
