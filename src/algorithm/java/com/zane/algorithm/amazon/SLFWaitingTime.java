package com.zane.algorithm.amazon;

/**
 * Author: luojinping
 * Date: 16/1/22
 * Time: 21:03
 */
public class SLFWaitingTime {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] requestTimes = {0, 2, 4, 5};
        int[] durations = {7, 4, 1, 4};
        float x = waitingAvg(requestTimes, durations);
        System.out.println(x); // x=4.0

        int[] requestTimes2 = {0, 2, 4, 7, 8};
        int[] durations2 = {3, 7, 2, 1, 4};
        float x2 = waitingAvg(requestTimes2, durations2);
        System.out.println(x2); // x=3.2
    }

    private static float waitingAvg(int[] requestTimes, int[] durations) {
        int len = requestTimes.length;

        int startTime[] = new int[len];
        int nextTask[] = new int[len];
        int nowTime = requestTimes[0];

        // run the first task firstly
        for (int i = 0; i < len; i++) {
            nextTask[i] = i;
        }

        int currentIndex = 1; // from the second task to find ready tasks

        // run task one by one according to the array of next task's index
        for (int i = 0; i < len; i++) {
            int taskIndex = nextTask[i];

            startTime[taskIndex] = nowTime;
            nowTime += durations[taskIndex];

            while (currentIndex < len) {
                if (requestTimes[currentIndex] < nowTime) {
                    // insert index to nextTask
                    int insertIndex = currentIndex;
                    for (int k = insertIndex - 1; k > i; k--) {
                        if (durations[insertIndex] < durations[nextTask[k]]) {
                            int temp = nextTask[k];
                            nextTask[k] = insertIndex;
                            nextTask[insertIndex] = temp;
                            insertIndex = k;
                        }
                    }

                    currentIndex++;
                } else {
                    break;
                }
            }
        }

        int waitingSum = 0;
        for (int x = 0; x < len; x++) {
            waitingSum += (startTime[x] - requestTimes[x]);
        }

        return (float) (waitingSum * 1.0 / len);
    }
}
