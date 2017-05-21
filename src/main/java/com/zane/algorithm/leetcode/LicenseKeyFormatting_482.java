package com.zane.algorithm.leetcode;

/**
 * Author: luojinping
 * Date: 17/4/16 下午4:11
 */
public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        String str = S.toUpperCase().replace("-", "");

        int firstGroupLen = str.length() % K;// 8%3=2
        int groupCnt = str.length() / K;// 8/3=2

        int start = 0, end = K;

        if (firstGroupLen > 0) {
            end = firstGroupLen;
            groupCnt++;
        }

        StringBuilder sb = new StringBuilder();
        while (groupCnt-- > 0) {
            sb.append(str.substring(start, end));
            if (groupCnt > 0) {
                sb.append("-");
            }
            start = end;
            end += K;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKeyFormatting_482 licenseKeyFormatting = new LicenseKeyFormatting_482();

        System.out.println(licenseKeyFormatting.licenseKeyFormatting("2-4A0r7-4k", 3));
        System.out.println(licenseKeyFormatting.licenseKeyFormatting("2-4A0r7-4k", 4));
    }

}
