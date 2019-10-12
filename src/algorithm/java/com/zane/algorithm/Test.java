package com.zane.algorithm;

/**
 * Author: luojinping
 * Date: 16/1/24
 * Time: 10:48
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(func(9999));
        System.out.println(func(99999));
        System.out.println(func(999999));
        System.out.println(func(123456789));
        // squarePatternPrint(0);
        // squarePatternPrint(1);
        // squarePatternPrint(2);
        // squarePatternPrint(3);
        // squarePatternPrint(4);
        // squarePatternPrint(9);
    }

    public static int func(int x) {
        int count = 0;
        while (x != 0) {
            count++;
            x = x & (x - 1);
        }
        return count;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static void squarePatternPrint(int n) {
        if (n == 0) {
            return;
        }

        int preEnd = 0, tailStart = 0;
        if (n % 2 == 0) {
            preEnd = (n - 2) * n + 1;
            tailStart = (n - 1) * n + 1;
        } else {
            preEnd = (n - 1) * n + 1;
            tailStart = (n - 2) * n + 1;
        }

        // print pre part
        for (int i = 1; i <= preEnd; i += 2 * n) {
            printLine(i, i + n - 1);
        }

        // print tail part
        for (int j = tailStart; j >= n + 1; j -= 2 * n) {
            printLine(j, j + n - 1);
        }
    }

    private static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i);
            if (i != end) {
                System.out.print("*");
            } else {
                System.out.println();
            }
        }
    }
    // METHOD SIGNATURE ENDS
}
