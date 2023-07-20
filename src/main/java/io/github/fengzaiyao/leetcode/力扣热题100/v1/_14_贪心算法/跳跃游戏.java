package io.github.fengzaiyao.leetcode.力扣热题100.v1._14_贪心算法;

// https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&id=top-100-liked

public class 跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        int maxPath = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPath) {
                continue;
            }
            maxPath = Math.max(maxPath, i + nums[i]);
        }
        return maxPath >= nums.length - 1;
    }
}
