package com.zane.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: luojinping
 * Date: 15/5/20
 * Time: 下午10:01
 */
public class IncludeMinSubArray {
    private static class Result {
        public int startIndex;
        public int endIndex;

        public Result(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "startIndex=" + startIndex +
                    ", endIndex=" + endIndex +
                    '}';
        }
    }

    private static List<Result> getMinSubArrayIndex(final int[] inputArray, final int[]
            inputTarget) {
        List<Result> results = new ArrayList<>();

        if (inputTarget.length == 1) {
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[i] == inputTarget[0]) {
                    Result result = new Result(i, i);
                    results.add(result);
                }
            }
            return results;
        }

        List<Result> subResults = getMinSubArrayIndex(inputArray, Arrays.copyOfRange(inputTarget, 0,
                inputTarget.length - 1));

        for (Result subResult : subResults) {
            boolean find = false;
            for (int i = subResult.startIndex + 1; i < subResult.endIndex; i++) {
                if (inputArray[i] == inputTarget[inputTarget.length - 1]) {
                    results.add(subResult);
                    find = true;
                    break;
                }
            }

            if (find) {
                continue;
            }

            int startIndex = subResult.startIndex, startDiff = 0;
            for (int i = subResult.startIndex; i >= 0; i--) {
                if (inputArray[i] == inputTarget[inputTarget.length - 1]) {
                    startDiff = subResult.startIndex - i;
                    startIndex = i;
                    break;
                }
            }

            int endIndex = subResult.endIndex, endDiff = 0;
            for (int i = subResult.endIndex; i < inputArray.length; i++) {
                if (inputArray[i] == inputTarget[inputTarget.length - 1]) {
                    endDiff = i - subResult.endIndex;
                    endIndex = i;
                    break;
                }
            }

            Result result = new Result(startIndex, endIndex);

            if (startDiff > 0 && endDiff > 0) {
                if (startDiff >= endDiff) {
                    result.startIndex = subResult.startIndex;
                    result.endIndex = endIndex;
                } else {
                    result.startIndex = startIndex;
                    result.endIndex = subResult.startIndex;
                }
            } else if (startDiff > 0) {
                result.startIndex = startIndex;
                result.endIndex = subResult.startIndex;
            } else if (endDiff > 0) {
                result.startIndex = subResult.startIndex;
                result.endIndex = endIndex;
            }

            results.add(result);
        }

        return results;
    }

    public static void main(String[] args) {
        int[] inputArray = {6, 5, 2, 3, 8, 1, 4, 6, 1, 5, 9, 10};
        int[] inputTarget = {5, 4, 1};

        List<Result> results = getMinSubArrayIndex(inputArray, inputTarget);

        System.out.println(results);
    }
}
