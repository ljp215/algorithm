package com.zane.algorithm.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 判断4个数字,是否可以通过加减乘除得到24
 * <p>
 * Author: luojinping
 * Date: 16/4/5
 * Time: 21:26
 */
public class Count24 {
    private static class Number {
        List<Integer> nums;
        int target;
        List<String> exp;

        public Number(Integer[] nums, int target) {
            this.nums = new ArrayList<>(Arrays.asList(nums));
            this.target = target;
            this.exp = new ArrayList<>();
        }

        Number create() {
            return new Number(nums.toArray(new Integer[nums.size()]), target);
        }

        boolean isHitTarget() {
            return nums.size() == 1 && nums.get(0) == target;
        }

        void add(int index, int value) {
            nums.add(index, value);
        }

        void removeByIndex(int index) {
            nums.remove(index);
        }

        int getNumSize() {
            return nums.size();
        }

        int getNumElement(int index) {
            return nums.get(index);
        }

        void addExp(String str) {
            exp.add(str);
        }

    }

    public boolean isValid(Number number) {
        if (number.getNumSize() == 1) {
            return number.isHitTarget();
        }

        // Random get two numbers from nums
        Number copy = number.create();

        for (int i = 0; i < number.getNumSize(); i++) {
            int x = number.getNumElement(i);
            copy.removeByIndex(i);

            for (int j = i + 1; j < number.getNumSize(); j++) {
                int y = number.getNumElement(j);

                copy.removeByIndex(j - 1);
                if (isSubValid(copy, x, y)) {
                    return true;
                }

                copy.add(j - 1, y);
            }

            copy.add(i, x);
        }

        return false;
    }

    private boolean isSubValid(Number number, int x, int y) {
        if (isValidByAdd(number, x + y)) {
            return true;
        }

        return isValidByAdd(number, x - y) ||
                isValidByAdd(number, x * y) || (y != 0 && isValidByAdd(number, x / y));

    }

    private boolean isValidByAdd(Number number, int newInt) {
        number.add(number.getNumSize(), newInt);

        if (number.nums.size() == 2) {
            for (int i : number.nums) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }

        if (isValid(number)) {
            return true;
        }

        number.removeByIndex(number.getNumSize() - 1);

        return false;
    }

    public static void main(String[] args) {
        Count24 count24 = new Count24();

//        System.out.println(count24.isValid(Arrays.asList(3, 5, 7, 8)));

        Number number1 = new Number(new Integer[]{1, 2, 3, 199}, 24); // 199/((3+1)*2)
        test(count24, number1);

        Number number2 = new Number(new Integer[]{1, 2, 37, 199}, 24); // false
        test(count24, number2);

        Number number3 = new Number(new Integer[]{3, 5, 7, 8}, 24); // 3*7+(8-5)
        test(count24, number3);
    }

    private static void test(Count24 count24, Number number) {
        System.out.println(count24.isValid(number));
    }
}
