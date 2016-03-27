package com.zane.algorithm.Tango;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Author: luojinping
 * Date: 15/6/7
 * Time: 上午11:45
 */
public class RemoveDuplicatedElements {
    public Integer[] removeDupl(int[] array) {
        Set<Integer> exist = new LinkedHashSet<>();
        for (int element : array) {
            exist.add(element);
        }
        return exist.toArray(new Integer[exist.size()]);
    }

    public static void main(String[] args) {
        RemoveDuplicatedElements removeDuplicatedElements = new RemoveDuplicatedElements();
        int[] nums1 = {1, 5, 4, 2, 7, 2, 6, 5};
        Integer[] result = removeDuplicatedElements.removeDupl(nums1);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
