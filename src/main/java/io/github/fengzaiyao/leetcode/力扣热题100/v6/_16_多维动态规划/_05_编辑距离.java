package io.github.fengzaiyao.leetcode.力扣热题100.v6._16_多维动态规划;

// https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&id=top-100-liked

public class _05_编辑距离 {

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "ate"));
    }

    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        // 删除
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        // 新增
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j - 1] 更新
                    // dp[i - 1][j]     删除
                    // dp[i][j - 1]     新增
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
