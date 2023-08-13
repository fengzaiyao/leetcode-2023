package io.github.fengzaiyao.leetcode.力扣热题100.v6._05_普通数组;

// https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&id=top-100-liked

public class _01_最大子数组和 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur += nums[i];
            if (cur < 0) {
                cur = 0;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
