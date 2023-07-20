package io.github.fengzaiyao.leetcode.力扣热题100.v1._05_普通数组;

// https://leetcode.cn/problems/first-missing-positive/

public class _111_缺失的第一个正数 {

    // 题解: https://leetcode.cn/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean haveOne = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                haveOne = true;
            }
            // 将小于0或者大于len的都变成1
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        // 如果数组不存在1,那么1就是最小的正整数
        if (!haveOne) {
            return 1;
        }
        // 将出现过的数字变成负数
        for (int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        // 如果有正数,那么就是最小正正数
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果都有连续的,如 1,2,3 那么直接 return 4
        return len + 1;
    }
}
