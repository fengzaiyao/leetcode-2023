package io.github.fengzaiyao.leetcode.力扣热题100.v2._05_普通数组;

// https://leetcode.cn/problems/first-missing-positive/

public class _05_1111_缺失的第一个正数 {

    // 题解: https://leetcode.cn/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean haveOne = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                haveOne = true;
            }
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        if (!haveOne) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        // 有一个不为负数，例如：[3,4,-1,1] => 2
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 全都是负数,例如：[1,2,3] => 4
        return len + 1;
    }
}
