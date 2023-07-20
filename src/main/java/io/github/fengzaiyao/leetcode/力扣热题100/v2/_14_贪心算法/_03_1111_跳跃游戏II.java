package io.github.fengzaiyao.leetcode.力扣热题100.v2._14_贪心算法;

// https://leetcode.cn/problems/jump-game-ii/

public class _03_1111_跳跃游戏II {

    // 题解: https://leetcode.cn/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/

    public static int jump(int[] nums) {
        int curEnd = 0;
        int maxLen = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxLen = Math.max(maxLen, i + nums[i]);
            if (i == curEnd) {
                cnt++;
                curEnd = maxLen;
            }
        }
        return cnt;
    }
}
