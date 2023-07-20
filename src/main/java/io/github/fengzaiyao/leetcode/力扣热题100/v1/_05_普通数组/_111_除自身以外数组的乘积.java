package io.github.fengzaiyao.leetcode.力扣热题100.v1._05_普通数组;

// https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&id=top-100-liked

public class _111_除自身以外数组的乘积 {

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4, 5}));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int left[] = new int[len];
        int right[] = new int[len];
        int ret[] = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i > 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = 0; i < len; i++) {
            ret[i] = left[i] * right[i];
        }
        return ret;
    }

}
