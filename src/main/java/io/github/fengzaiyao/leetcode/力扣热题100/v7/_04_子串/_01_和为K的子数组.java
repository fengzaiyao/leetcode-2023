package io.github.fengzaiyao.leetcode.力扣热题100.v7._04_子串;

// https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&id=top-100-liked

public class _01_和为K的子数组 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = 0; i < preSum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
