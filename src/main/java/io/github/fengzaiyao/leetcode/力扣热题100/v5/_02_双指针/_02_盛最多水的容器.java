package io.github.fengzaiyao.leetcode.力扣热题100.v5._02_双指针;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&id=top-100-liked

public class _02_盛最多水的容器 {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            // 计算当前面积
            int w = r - l;
            int h = Math.min(height[r], height[l]);
            max = Math.max(max, w * h);
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
