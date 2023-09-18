package io.github.fengzaiyao.leetcode.力扣热题100.v7._15_动态规划;

// https://leetcode.cn/problems/partition-equal-subset-sum/?envType=study-plan-v2&id=top-100-liked

public class _09_分割等和子集 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
