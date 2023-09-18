package io.github.fengzaiyao.leetcode.力扣热题100.v7._15_动态规划;

// https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&id=top-100-liked

public class _03_打家劫舍 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[2][len + 1];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + nums[i]);
        }
        return Math.max(dp[0][len - 1], dp[1][len - 1]);
    }
}
