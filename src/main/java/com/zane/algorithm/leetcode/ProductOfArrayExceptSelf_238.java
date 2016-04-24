package main.com.zane.leetcode;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the
 * purpose of space complexity analysis.)
 * <p>
 * Created by jinpiluo on 3/29/16.
 */
public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        // put the result of front elements product result
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            nums[j] *= nums[j + 1];
            res[j] *= nums[j + 1];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf_238 productOfArrayExceptSelf = new ProductOfArrayExceptSelf_238();
        int[] res = productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i : res)
            System.out.print(i + ", ");
    }
}
