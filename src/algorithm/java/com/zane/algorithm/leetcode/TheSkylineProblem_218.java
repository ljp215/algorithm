package com.zane.algorithm.leetcode;

import java.util.*;

/**
 * Author: luojinping
 * Date: 16/3/22
 * Time: 15:34
 */
public class TheSkylineProblem_218 {
    public List<int[]> getSkylineSimpleSolution(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        // height < 0: the height of building started
        // height > 0: the height of building ended
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        // sorted by x value, if x equals then sorted by height value
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        // record the height of visited buildings by reverse order
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);

        int prevHeight = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                // save the height of building
                pq.offer(-h[1]);
            } else {
                // remove the height of building
                pq.remove(h[1]);
            }

            int curHeight = pq.peek();

            if (prevHeight != curHeight) {
                // find the turn point
                result.add(new int[]{h[0], curHeight});
                prevHeight = curHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TheSkylineProblem_218 theSkylineProblem = new TheSkylineProblem_218();

        int buildings[][] = new int[5][3];
        buildings[0][0] = 2;
        buildings[0][1] = 9;
        buildings[0][2] = 10;
        buildings[1][0] = 3;
        buildings[1][1] = 7;
        buildings[1][2] = 15;
        buildings[2][0] = 5;
        buildings[2][1] = 12;
        buildings[2][2] = 12;
        buildings[3][0] = 15;
        buildings[3][1] = 20;
        buildings[3][2] = 10;
        buildings[4][0] = 19;
        buildings[4][1] = 24;
        buildings[4][2] = 8;

        List<int[]> skyline = theSkylineProblem.getSkylineSimpleSolution(buildings);
        for (int[] point : skyline) {
            System.out.print(point[0] + " ");
            System.out.print(point[1] + " ");
            System.out.println();
        }

        int buildings2[][] = new int[2][3];
        buildings2[0][0] = 1;
        buildings2[0][1] = 10;
        buildings2[0][2] = 2;
        buildings2[1][0] = 3;
        buildings2[1][1] = 5;
        buildings2[1][2] = 20;

        List<int[]> skyline2 = theSkylineProblem.getSkylineSimpleSolution(buildings2);
        for (int[] point : skyline2) {
            System.out.print(point[0] + " ");
            System.out.print(point[1] + " ");
            System.out.println();
        }

        int buildings3[][] = new int[3][3];
        buildings3[0][0] = 1;
        buildings3[0][1] = 2;
        buildings3[0][2] = 1;
        buildings3[1][0] = 1;
        buildings3[1][1] = 2;
        buildings3[1][2] = 2;
        buildings3[2][0] = 1;
        buildings3[2][1] = 2;
        buildings3[2][2] = 3;

        List<int[]> skyline3 = theSkylineProblem.getSkylineSimpleSolution(buildings3);
        for (int[] point : skyline3) {
            System.out.print(point[0] + " ");
            System.out.print(point[1] + " ");
            System.out.println();
        }
    }
}
