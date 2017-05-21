package com.zane.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: luojinping
 * Date: 17/5/14 上午9:00
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points
 * (i, j, k) such that the distance between i and j equals the distance between i and k (the order
 * of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of
 * points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * 
 * Output:
 * 2
 * 
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 */
public class Number_of_Boomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {
        double[][] pointsDis = new double[points.length][points.length];

        int res = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> disPoints = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                double distance = pointsDis[i][j];
                if (distance == 0) {
                    distance = computeDistance(points[i], points[j]);
                    pointsDis[i][j] = distance;
                    pointsDis[j][i] = distance;
                }

                Integer pointsCount = disPoints.get(distance);
                if (pointsCount != null) {
                    pointsCount++;
                } else {
                    pointsCount = 1;
                }
                disPoints.put(distance, pointsCount);
            }

            for (int pointsCount : disPoints.values()) {
                res += pointsCount * (pointsCount - 1);
            }

        }

        return res;
    }

    private double computeDistance(int[] pointX, int[] pointY) {
        return Math.pow(Math.pow(pointY[0] - pointX[0], 2) + Math.pow(pointY[1] - pointX[1], 2),
                0.5);
    }

    public static void main(String[] args) {
        Number_of_Boomerangs_447 numberOfBoomerangs = new Number_of_Boomerangs_447();

        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs.numberOfBoomerangs(points));
    }
}
