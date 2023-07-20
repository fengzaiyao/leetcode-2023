package io.github.fengzaiyao.leetcode.力扣热题100.v1._15_动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/

public class 乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2,0,-1}));
    }

    public static int maxProduct(int[] nums) {
        int maxVal = nums[0];
        int max = 1;
        int min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            maxVal = Math.max(maxVal, max);
        }
        return maxVal;
    }
}
