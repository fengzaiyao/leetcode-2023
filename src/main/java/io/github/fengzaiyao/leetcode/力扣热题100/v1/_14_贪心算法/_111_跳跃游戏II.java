package io.github.fengzaiyao.leetcode.力扣热题100.v1._14_贪心算法;

// https://leetcode.cn/problems/jump-game-ii/

public class _111_跳跃游戏II {

    // 题解: https://leetcode.cn/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/

    public int jump(int[] nums) {
        // 当前更新边界
        int curEnd = 0;
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxLen = Math.max(maxLen, nums[i] + i);
            if (i == curEnd) {
                count++;
                curEnd = maxLen;
            }
        }
        return count;
    }
}
