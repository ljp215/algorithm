package com.zane.algorithm.math;

import java.util.Random;

/**
 * Author: luojinping@gotokeep.com
 * Date: 2018/10/26 下午7:11
 */
public class ConditionalProbabilityTest {
    public static final int DOOR_COUNT = 3;
    public static final int DOOR_INDEX_SUM = (DOOR_COUNT * (DOOR_COUNT - 1)) / 2;

    public static void main(String[] args) {
        ConditionalProbabilityTest test = new ConditionalProbabilityTest();

        int n = 100;
        while (n-- > 0) {
            test.compare(1000000);
        }
    }

    public void compare(int experimentCount) {
        int changeWin = 0, unchangeWin = 0;

        while (experimentCount > 0) {
            int[] doors = random();

            int choiceDoor = getRandomIndex();

            // int openedDoor = 0;
            // while (openedDoor < DOOR_COUNT) {
            // if (openedDoor != choiceDoor && doors[openedDoor] == 0) {
            // break;
            // }
            // openedDoor++;
            // }

            int openedDoor = getRandomIndex(choiceDoor);

            if (doors[openedDoor] == 1) {
                continue;
            }

            if (change(doors, choiceDoor, openedDoor)) {
                changeWin++;
            }

            if (unchange(doors, choiceDoor, openedDoor)) {
                unchangeWin++;
            }

            experimentCount--;
        }

        System.out.printf("experimentCount: %s, changeWin: %s, unchangeWin: %s \n", experimentCount,
                changeWin, unchangeWin);
    }

    public int[] random() {
        int[] doors = new int[DOOR_COUNT];

        doors[getRandomIndex()] = 1;

        return doors;
    }

    public boolean change(int[] doors, int choice, int openedDoor) {
        int newChoice = DOOR_INDEX_SUM - choice - openedDoor;

        return doors[newChoice] == 1;
    }

    public boolean unchange(int[] doors, int choice, int openedDoor) {
        return doors[choice] == 1;
    }

    public int getRandomIndex() {
        Random random = new Random();
        return Math.abs(random.nextInt()) % DOOR_COUNT;
    }

    public int getRandomIndex(int duplicate) {
        int result = duplicate;

        Random random;
        while (result == duplicate) {
            random = new Random();
            result = Math.abs(random.nextInt()) % DOOR_COUNT;
        }

        return result;
    }
}
