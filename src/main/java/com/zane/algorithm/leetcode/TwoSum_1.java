package com.zane.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Author: luojinping
 * Date: 16/2/29
 * Time: 09:46
 * <p/>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum_1 {
    public int[] solution(int nums[], int target) {
        int numsOriginal[] = Arrays.copyOf(nums, nums.length);

        int towNums[] = new int[2];

        Arrays.sort(nums);

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
                continue;
            }
            if (sum > target) {
                j--;
                continue;
            }

            towNums[0] = nums[i];
            towNums[1] = nums[j];
            break;
        }

        int solution[] = new int[2];
        solution[0] = -1;
        solution[1] = -1;
        for (int k = 0; k < numsOriginal.length; k++) {
            if (numsOriginal[k] == towNums[0] && solution[0] == -1) {
                solution[0] = k;
            } else if (numsOriginal[k] == towNums[1] && solution[1] == -1) {
                solution[1] = k;
            }

        }

        return solution;
    }

    /**
     * use hashMap to record num
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] easySolution(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] eresult = {0, 0};

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] result = {map.get(nums[i]) + 1, i + 1};
                return result;
            }
            map.put(target - nums[i], i);
        }
        return eresult;
    }

    public static void main(String[] args) {
        TwoSum_1 twoSum = new TwoSum_1();

        int[] nums = {7, 2, 11, 15};
        for (int i : twoSum.solution(nums, 9)) {
            System.out.println(i);
        }

        int[] nums2 = {150, 24, 79, 50, 88, 345, 3};
        for (int i : twoSum.solution(nums2, 200)) {
            System.out.println(i);
        }


        int[] nums3 = {2, 1, 9, 4, 4, 56, 90, 3};
        for (int i : twoSum.solution(nums3, 8)) {
            System.out.println(i);
        }
    }
}