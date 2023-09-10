package io.github.fengzaiyao.leetcode.力扣热题100.v7._05_普通数组;

// https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&id=top-100-liked

import java.util.Arrays;

public class _04_除自身以外数组的乘积 {

    public static void main(String[] args) {
        int[] nums = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(nums));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];
        l[0] = 1;
        r[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        System.out.println(Arrays.toString(l));
        System.out.println(Arrays.toString(r));
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }

}
