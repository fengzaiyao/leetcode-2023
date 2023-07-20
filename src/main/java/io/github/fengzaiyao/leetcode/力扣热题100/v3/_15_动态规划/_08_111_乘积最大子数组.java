package io.github.fengzaiyao.leetcode.力扣热题100.v3._15_动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/

public class _08_111_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
       // System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        // 初始条件是 1 !!!
        int max = 1;
        int min = 1;
        int maxAns = nums[0];
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(num, num * max);
            min = Math.min(num, num * min);
            maxAns = Math.max(maxAns, max);
        }
        return maxAns;
    }
}
