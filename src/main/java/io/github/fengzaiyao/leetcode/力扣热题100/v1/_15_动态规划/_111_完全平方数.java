package io.github.fengzaiyao.leetcode.力扣热题100.v1._15_动态规划;

// https://leetcode.cn/problems/perfect-squares/

public class _111_完全平方数 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
