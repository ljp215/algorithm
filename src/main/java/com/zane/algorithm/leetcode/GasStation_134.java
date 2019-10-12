package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 2019/8/19 6:57 PM
 */
public class GasStation_134 {
    public static void main(String[] arg) {
        // Scanner sc = new Scanner(System.in);
        // List<String> strList = new ArrayList<>();
        // while (sc.hasNextLine()) {
        // strList.add(sc.nextLine());
        // }
        //
        // String[] waterList = strList.get(0).replace("[", "").replace("]", "").split(",");
        // String[] costList = strList.get(1).replace("[", "").replace("]", "").split(",");
        // int len = waterList.length;
        // int[] water = new int[len];
        // int[] cost = new int[len];
        //
        // for (int i = 0; i < len; i++) {
        // water[i] = Integer.parseInt(waterList[i]);
        // cost[i] = Integer.parseInt(costList[i]);
        // }

        int[] water = new int[] {2, 2, 3, 1, 3, 4, 1, 2, 3, 1};
        int[] cost = new int[] {3, 3, 2, 2, 5, 1, 1, 1, 5, 2};
        canCompleteCircuit(water, cost);
    }

    static void canCompleteCircuit(int[] water, int[] cost) {
        int N = water.length, startIndex = -1;
        int sum = 0, total = 0;
        for (int i = 0; i < N; i++) {
            sum += (water[i] - cost[i]);
            total += (water[i] - cost[i]);
            if (sum < 0) {
                startIndex = i;
                sum = 0;
            }
        }

        int result = total >= 0 ? startIndex + 1 : -1;

        System.out.println(result);
    }
}
