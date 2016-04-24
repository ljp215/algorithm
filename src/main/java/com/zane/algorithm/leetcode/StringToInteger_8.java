package main.com.zane.leetcode;

/**
 * Implement atoi to convert a string to an integer.
 * <p>
 * <p>
 * Created by jinpiluo on 3/30/16.
 */
public class StringToInteger_8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean hadSign = false;
        boolean isPositive = true;
        boolean startedConvert = false;

        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') {
                if (startedConvert) {
                    break;
                }
                continue;
            }

            if (ch == '+' || ch == '-') {
                if (hadSign) {
                    break;
                }

                hadSign = true;
                isPositive = ch == '+' ? true : false;
                startedConvert = true;
            } else if (ch < '0' || ch > '9') {
                break;
            } else {
                if ((Integer.MAX_VALUE - (ch - '0')) / 10 < res ) {
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                res = res * 10 + (ch - '0');
                startedConvert = true;
            }
        }

        return isPositive ? res : -1 * res;
    }

    public static void main(String[] args) {
        StringToInteger_8 stringToInteger = new StringToInteger_8();
        System.out.println(stringToInteger.myAtoi("    10522545459"));
    }
}
