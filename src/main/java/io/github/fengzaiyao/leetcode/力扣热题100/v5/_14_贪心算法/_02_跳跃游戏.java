package io.github.fengzaiyao.leetcode.力扣热题100.v5._14_贪心算法;

// https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&id=top-100-liked

public class _02_跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex >= i) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
