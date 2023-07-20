package io.github.fengzaiyao.leetcode.力扣热题100.v2._15_动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/

public class _08_111_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        int maxVal = 1;
        int minVal = 1;
        int maxAns = nums[0];
        for (int num : nums) {
            if (num < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }
            maxVal = Math.max(num, num * maxVal);
            minVal = Math.min(num, num * minVal);
            maxAns = Math.max(maxAns, maxVal);
        }
        return maxAns;
    }
}
