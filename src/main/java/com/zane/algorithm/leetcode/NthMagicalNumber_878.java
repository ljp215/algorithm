package com.zane.algorithm.leetcode;

/**
 * A positive integer is magical if it is divisible by either A or B.
 *
 * Return the N-th magical number. Since the answer may be very large, return it modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 1, A = 2, B = 3
 * Output: 2
 * Example 2:
 *
 * Input: N = 4, A = 2, B = 3
 * Output: 6
 * Example 3:
 *
 * Input: N = 5, A = 2, B = 4
 * Output: 10
 * Example 4:
 *
 * Input: N = 3, A = 6, B = 4
 * Output: 8
 *
 *
 * Note:
 *
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 *
 * Author: luojinping
 * Date: 2018/8/9 下午3:52
 */
public class NthMagicalNumber_878 {
    public int nthMagicalNumberJP(int N, int A, int B) {
        int timesA = 1, timesB = 1, numA, numB, index = 1;

        if (N == 1) {
            return A < B ? A : B;
        }

        if (A > B) {
            return nthMagicalNumberJP(N, B, A);
        }

        numA = A;
        numB = B;

        int result = A;
        while (index < N) {
            if (numA <= numB) {
                timesA++;
                numA = timesA * A;
                result = numA;
            } else {
                timesB++;
                numB = timesB * B;
                result = numB;
            }

            if (numA != numB) {
                index++;
            }
        }

        return result;
    }


    private long MOD = 1000000007;

    public int nthMagicalNumber(int N, int A, int B) {
        // trivial case, A == B, so the N-th largest is N * A
        if (A == B) {
            return (int) ((((long) A) * ((long) N)) % MOD);
        }

        // switching A and B is just the same, we can enforce A < B
        if (A > B) {
            return nthMagicalNumber(N, B, A);
        }

        // now A < B

        // divide by gcd
        int c = gcd(A, B);
        long a = (long) (A / c);
        long b = (long) (B / c);

        // determine how many cycles are there
        long cycles = ((long) N) / (a + b - 1);
        long n = ((long) N) % (a + b - 1);

        // base case, solve it by binary search
        long result = nthMagicalNumberLong(n, a, b);

        // put the result together
        return (int) ((a * b * cycles * ((long) c) + result * ((long) c)) % MOD);
    }

    private long nthMagicalNumberLong(long n, long a, long b) {
        // trivial cases
        if (n == 0) {
            return 0;
        }
        if (a == 1) {
            return n;
        }

        // now n > 0, n < a + b - 1 and a < b and gcd(a, b) = 1
        // use binary search and some math to determine the result
        long lo = a - 1;
        long hi = a * b + 1;
        long result = 0;
        while (lo < hi) {
            long mi = (lo + hi) / 2;
            if (mi / a + mi / b > n) {
                hi = mi;
            } else if (mi / a + mi / b < n) {
                lo = mi;
            } else {
                // hooray, we've located the number range!
                // the number must satisfy the condition:
                // num / a + num / b = n and (num % a == 0 or num % b == 0)
                // hence the maximum of (mi / a) * a and (mi / b) * b must be the num
                // since for num - 1, the condition will fail
                long x = mi / a;
                long y = mi / b;
                result = Math.max(x * a, y * b) % MOD;
                break;
            }
        }
        return result;
    }

    // greatest common divisor
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        NthMagicalNumber_878 nthMagicalNumber = new NthMagicalNumber_878();

        System.out.println(nthMagicalNumber.gcd(2, 3));
        System.out.println(nthMagicalNumber.gcd(2, 4));
        System.out.println(nthMagicalNumber.gcd(4, 8));
        System.out.println(nthMagicalNumber.gcd(12, 36));


        System.out.println(nthMagicalNumber.nthMagicalNumber(1, 2, 3));
        System.out.println(nthMagicalNumber.nthMagicalNumber(4, 2, 3));
        System.out.println(nthMagicalNumber.nthMagicalNumber(5, 2, 4));
        System.out.println(nthMagicalNumber.nthMagicalNumber(5, 4, 2));
        System.out.println(nthMagicalNumber.nthMagicalNumber(2, 7, 3));

        // 太慢了！
        System.out.println(nthMagicalNumber.nthMagicalNumber(1000000000, 40000, 40000));
    }
}
