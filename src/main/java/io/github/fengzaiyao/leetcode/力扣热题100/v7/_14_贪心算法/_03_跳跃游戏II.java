package io.github.fengzaiyao.leetcode.力扣热题100.v7._14_贪心算法;

// https://leetcode.cn/problems/jump-game-ii/

public class _03_跳跃游戏II {

    // 题解: https://leetcode.cn/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/

    public static int jump(int[] nums) {
        int endIdx = 0;
        int curIdx = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curIdx = Math.max(curIdx, i + nums[i]);
            if (i == endIdx) {
                endIdx = curIdx;
                count++;
            }
        }
        return count;
    }
}
