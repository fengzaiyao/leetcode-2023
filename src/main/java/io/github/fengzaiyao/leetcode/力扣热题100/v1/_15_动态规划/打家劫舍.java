package io.github.fengzaiyao.leetcode.力扣热题100.v1._15_动态规划;

// https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&id=top-100-liked

public class 打家劫舍 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        // dp[i][0] 第i个屋子没有偷的利润, dp[i][1] 第i个屋子偷的利润
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
