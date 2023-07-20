package io.github.fengzaiyao.leetcode.力扣热题100.v4._15_动态规划;

// https://leetcode.cn/problems/maximum-product-subarray/

public class _08_111_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }

    public static int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int ans = nums[0];
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            // 只取num,意味着抛弃前面的！！！
            max = Math.max(num, max * num);
            min = Math.min(num, min * num);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
