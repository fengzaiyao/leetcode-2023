package io.github.fengzaiyao.leetcode.力扣热题100.v3._15_动态规划;

import java.util.Arrays;

// https://leetcode.cn/problems/longest-increasing-subsequence/?envType=study-plan-v2&id=top-100-liked

public class _07_最长递增子序列 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            int curMax = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curMax = Math.max(curMax, dp[j]);
                }
            }
            dp[i] = Math.max(dp[i], curMax + 1);
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
