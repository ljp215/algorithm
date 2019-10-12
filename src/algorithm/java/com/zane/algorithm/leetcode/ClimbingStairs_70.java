package main.com.zane.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Created by jinpiluo on 3/29/16.
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int beforeTwoStair = 1;
        int beforeOneStair = 2;

        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = beforeOneStair + beforeTwoStair;
            beforeTwoStair = beforeOneStair;
            beforeOneStair = cur;
        }

        return cur;
    }
}
