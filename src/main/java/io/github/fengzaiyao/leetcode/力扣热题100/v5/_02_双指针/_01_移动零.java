package io.github.fengzaiyao.leetcode.力扣热题100.v5._02_双指针;

// https://leetcode.cn/problems/move-zeroes/

public class _01_移动零 {

    public void moveZeroes(int[] nums) {
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
