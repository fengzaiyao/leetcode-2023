package io.github.fengzaiyao.leetcode.力扣热题100.v1._16_多维动态规划;

import java.util.Arrays;

// https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&id=top-100-liked

public class 不同路径 {

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
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m - 1][n - 1];
    }
}
