package io.github.fengzaiyao.leetcode.力扣热题100.v9._15_动态规划;

// https://leetcode.cn/problems/climbing-stairs/

public class _01_爬楼梯 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
