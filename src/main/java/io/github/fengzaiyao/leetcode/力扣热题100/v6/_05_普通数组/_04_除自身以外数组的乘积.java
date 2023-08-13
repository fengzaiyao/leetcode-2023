package io.github.fengzaiyao.leetcode.力扣热题100.v6._05_普通数组;

// https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&id=top-100-liked

import java.util.Arrays;

public class _04_除自身以外数组的乘积 {

    public static void main(String[] args) {
        int[] nums = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(nums));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

}
