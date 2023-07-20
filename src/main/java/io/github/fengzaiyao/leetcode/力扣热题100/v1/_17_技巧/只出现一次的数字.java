package io.github.fengzaiyao.leetcode.力扣热题100.v1._17_技巧;

// https://leetcode.cn/problems/single-number/

public class 只出现一次的数字 {

    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
