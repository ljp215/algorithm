package com.zane.algorithm.keep;

/**
 * Author: luojinping@gotokeep.com
 * Date: 2018/8/14 下午8:48
 */
public class FindMaxTrainingArea {
    public static void fun(String[] args) {
        System.out.println(args);
        System.out.print(args[0]);
        System.out.print(args[1]);
        int rowSize = Integer.parseInt(args[0]);
        int columnSize = Integer.parseInt(args[1]);

        int[][] matrix = new int[rowSize][columnSize];
        for (int i = 2; i < args.length; i++) {
            System.out.print(args[i]);
            matrix[i / columnSize][i % columnSize] = Integer.parseInt(args[i]);
            System.out.print(matrix[i / columnSize][i % columnSize]);
        }
    }

    public static void main(String[] args) {
        String[] array = new String[] {"4", "5", "1", "0", "1", "0", "0", "1", "0", "1", "1", "1",
                "1", "1", "1", "1", "1", "1", "0", "0", "1", "0"};
        fun(array);
    }
}
