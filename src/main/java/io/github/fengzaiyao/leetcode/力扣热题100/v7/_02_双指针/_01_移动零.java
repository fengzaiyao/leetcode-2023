package io.github.fengzaiyao.leetcode.力扣热题100.v7._02_双指针;

// https://leetcode.cn/problems/move-zeroes/

import java.util.Arrays;

public class _01_移动零 {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                nums[i - zeroCnt] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0 && zeroCnt > 0; i--) {
            nums[i] = 0;
            zeroCnt--;
        }
    }
}
