package io.github.fengzaiyao.leetcode.力扣热题100.v7._15_动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/

public class _08_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            min = Math.min(nums[i], nums[i] * min);
            max = Math.max(nums[i], nums[i] * max);
            maxSum = Math.max(maxSum, max);
        }
        return maxSum;
    }
}
