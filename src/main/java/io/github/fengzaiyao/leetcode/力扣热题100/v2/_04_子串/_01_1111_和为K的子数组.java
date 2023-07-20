package io.github.fengzaiyao.leetcode.力扣热题100.v2._04_子串;

// https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&id=top-100-liked

public class _01_1111_和为K的子数组 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        // preSum[i] 前 i 个数之和
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int len = 0; len <= nums.length; len++) {
            for (int j = len + 1; j <= nums.length; j++) {
                if (preSum[j] - preSum[len] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
