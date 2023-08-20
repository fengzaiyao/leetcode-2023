package io.github.fengzaiyao.leetcode.力扣热题100.v6._15_动态规划;

// https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&id=top-100-liked

public class _03_打家劫舍 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
