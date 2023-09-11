package io.github.fengzaiyao.leetcode.力扣热题100.v7._02_双指针;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&id=top-100-liked

public class _02_盛最多水的容器 {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
