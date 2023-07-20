package io.github.fengzaiyao.leetcode.力扣热题100.v4._15_动态规划;

// https://leetcode.cn/problems/perfect-squares/

public class _04_完全平方数 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
