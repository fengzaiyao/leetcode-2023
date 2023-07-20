package io.github.fengzaiyao.leetcode.力扣热题100.v2._16_多维动态规划;

// https://leetcode.cn/problems/longest-common-subsequence/?envType=study-plan-v2&id=top-100-liked

public class _04_最长公共子序列 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int t1Len = text1.length();
        int t2Len = text2.length();
        int[][] dp = new int[t1Len + 1][t2Len + 1];
        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1Len][t2Len];
    }
}
