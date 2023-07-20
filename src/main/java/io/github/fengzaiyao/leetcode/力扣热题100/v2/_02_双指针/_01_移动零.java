package io.github.fengzaiyao.leetcode.力扣热题100.v2._02_双指针;

// https://leetcode.cn/problems/move-zeroes/

public class _01_移动零 {

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{0, 1});
    }

    public static void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else {
                nums[i - zeroNum] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0 && zeroNum > 0; i--, zeroNum--) {
            nums[i] = 0;
        }
    }
}
