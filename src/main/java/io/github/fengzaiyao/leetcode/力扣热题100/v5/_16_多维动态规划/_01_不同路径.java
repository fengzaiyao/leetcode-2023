package io.github.fengzaiyao.leetcode.力扣热题100.v5._16_多维动态规划;

// https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=top-100-liked

public class _01_不同路径 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
