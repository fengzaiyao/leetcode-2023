package io.github.fengzaiyao.leetcode.力扣热题100.v6._02_双指针;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&id=top-100-liked

public class _02_盛最多水的容器 {

    public int maxArea(int[] height) {
        int maxVal = -1;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int w = Math.abs(l - r);
            maxVal = Math.max(maxVal, h * w);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxVal;
    }
}
