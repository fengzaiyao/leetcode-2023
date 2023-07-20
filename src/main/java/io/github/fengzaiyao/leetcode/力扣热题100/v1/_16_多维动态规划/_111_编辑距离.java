package io.github.fengzaiyao.leetcode.力扣热题100.v1._16_多维动态规划;

// https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&id=top-100-liked

public class _111_编辑距离 {

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "ate"));
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //  dp[i - 1][j - 1] = 替换、dp[i - 1][j] = 删除、dp[i][j - 1] = 插入
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}
