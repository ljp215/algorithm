package com.zane.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: luojinping
 * Date: 16/2/2
 * Time: 21:31
 */
public class CoinChange_322 {

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        return coinChange(coins, amount, 0, 0);
    }

    private static int coinChange(int[] coins, int amount, int usedCoinIndex, int coinCount) {
        int minMemberCount = -1;

        int useCount = 0;
        int change = amount - useCount * coins[usedCoinIndex];

        while (change >= 0) {
            int memberCountRes = 0;

            if (change == 0) {
                memberCountRes = coinCount + useCount;
            } else if (change > 0) {
                if (usedCoinIndex + 1 < coins.length) {
                    memberCountRes = coinChange(coins, change, usedCoinIndex + 1, coinCount +
                            useCount);
                }
            }

            if (memberCountRes > 0 && (minMemberCount == -1 || minMemberCount > memberCountRes)) {
                minMemberCount = memberCountRes;
            }

            useCount += 1;
            change = amount - useCount * coins[usedCoinIndex];
        }

        return minMemberCount;
    }

    /**
     * recursive DP solution
     * <p/>
     * O(c^n), c is the number of different coins, n is the amount given
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = amount + 1; // the answer must smaller than [amount+1], nice!
        for (int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange2(coins, amount - coin);
                if (next >= 0)
                    curr = 1 + next;
            }
            if (curr > 0)
                n = Math.min(n, curr);
        }
        return (n == amount + 1) ? -1 : n;
    }

    Map<Integer, Integer> amountDict = new HashMap<Integer, Integer>();


    /**
     * O(n^c), c is the number of different coins, n is the amount given
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amountDict.containsKey(amount))
            return amountDict.get(amount);
        int n = amount + 1;
        for (int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange3(coins, amount - coin);
                if (next >= 0)
                    curr = 1 + next;
            }
            if (curr > 0)
                n = Math.min(n, curr);
        }
        int finalCount = (n == amount + 1) ? -1 : n;
        amountDict.put(amount, finalCount);
        return finalCount;
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange4(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != amount + 1)
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        if (minNumber[amount] == amount + 1)
            return -1;
        else
            return minNumber[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{2};
        amount = 3;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{1, 2, 5};
        amount = 100;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{1, 6, 9};
        amount = 12;
        System.out.println(coinChange(coins, amount)); // result is 6, 6, not 9, 1, 1, 1

        coins = new int[]{186, 419, 83, 408};
        amount = 6249;
        System.out.println(coinChange(coins, amount));

        coins = new int[]{493, 416, 144, 164, 314, 25};
        amount = 5607;
        System.out.println(coinChange(coins, amount));
    }

}
