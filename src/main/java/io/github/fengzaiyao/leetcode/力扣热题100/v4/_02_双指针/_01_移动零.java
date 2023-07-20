package io.github.fengzaiyao.leetcode.力扣热题100.v4._02_双指针;

// https://leetcode.cn/problems/move-zeroes/

public class _01_移动零 {

    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }
        // 从后往前设置0
        for (int i = nums.length - 1; i > 0 && zeroCount > 0; i--, zeroCount--) {
            nums[i] = 0;
        }
    }
}
