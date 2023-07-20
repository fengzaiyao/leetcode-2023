package io.github.fengzaiyao.leetcode.力扣热题100.v1._17_技巧;

// https://leetcode.cn/problems/sort-colors/?envType=study-plan-v2&id=top-100-liked

public class 颜色分类 {

    public void sortColors(int[] nums) {
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
            }
        }
    }
}
