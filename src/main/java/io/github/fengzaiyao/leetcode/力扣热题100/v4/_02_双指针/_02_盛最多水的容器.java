package io.github.fengzaiyao.leetcode.力扣热题100.v4._02_双指针;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&id=top-100-liked

public class _02_盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, Math.abs(r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
