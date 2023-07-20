package io.github.fengzaiyao.leetcode.力扣热题100.v1._02_双指针;

// https://leetcode.cn/problems/move-zeroes/

public class 移动零 {

    public void moveZeroes(int[] nums) {
        // 前面有多少个0
        int count = 0;
        int endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
                continue;
            }
            nums[i - count] = nums[i];
            endIndex = i - count;
        }
        for (int i = endIndex + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
