package io.github.fengzaiyao.leetcode.力扣热题100.v6._15_动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/

import java.time.temporal.ChronoUnit;

public class _08_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
