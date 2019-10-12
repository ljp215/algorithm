package com.zane.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive,
 * return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 * <p>
 * Author: luojinping
 * Date: 16/3/27
 * Time: 18:02
 */
public class MissingRanges_163 {
    public List<String> getMissingRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int pre = -1;

        for (int num : nums) {
            if (num != pre && num != pre + 1) {
                if (num == pre + 2) {
                    res.add(String.valueOf(pre + 1));
                } else {
                    res.add(String.valueOf(pre + 1) + "->" + String.valueOf(num - 1));
                }
            }
            pre = num;
        }

        return res;
    }

    public static void main(String[] args) {
        MissingRanges_163 missingRanges = new MissingRanges_163();

        test(missingRanges, new int[]{0, 1, 3, 50, 75});

        test(missingRanges, new int[]{2, 3, 4, 50, 75});

    }

    private static void test(MissingRanges_163 missingRanges, int[] nums) {
        for (String s : missingRanges.getMissingRanges(nums)) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }

}
