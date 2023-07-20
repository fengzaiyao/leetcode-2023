package io.github.fengzaiyao.leetcode.力扣热题100.v1._17_技巧;

// https://leetcode.cn/problems/majority-element/

public class 多数元素 {

    public int majorityElement(int[] nums) {
        int count = 1;
        int curNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                curNum = nums[i];
            }
            if (curNum != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return curNum;
    }
}
