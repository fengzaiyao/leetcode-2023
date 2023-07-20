package io.github.fengzaiyao.leetcode.力扣热题100.v4._14_贪心算法;

// https://leetcode.cn/problems/jump-game-ii/

public class _03_跳跃游戏II {

    // 题解: https://leetcode.cn/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/

    public static int jump(int[] nums) {
        int count = 0;
        int endIndex = 0;
        int maxIndex = 0;
        // nums.length - 1 是因为达到最后一个格子就不用在跳跃了
        for (int i = 0; i < nums.length - 1; i++) {
            // 每次更新最大能跳多远
            maxIndex = Math.max(maxIndex, i + nums[i]);
            // 达到需要界限就更新
            if (i == endIndex) {
                endIndex = maxIndex;
                count++;
            }
        }
        return count;
    }
}
