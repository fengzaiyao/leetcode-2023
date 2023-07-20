package io.github.fengzaiyao.leetcode.力扣热题100.v1._15_动态规划;

// https://leetcode.cn/problems/partition-equal-subset-sum/?envType=study-plan-v2&id=top-100-liked

public class _111_分割等和子集 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 == 1) {
            return false;
        }
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        // 只能使用一次，将要列表放在最外边
        for (int num : nums) {
            // 从后往前,避免数据被本轮更新
            for (int i = target; i >= 1; i--) {
                if (i - num >= 0) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
