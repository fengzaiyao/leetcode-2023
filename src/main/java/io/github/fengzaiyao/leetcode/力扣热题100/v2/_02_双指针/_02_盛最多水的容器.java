package io.github.fengzaiyao.leetcode.力扣热题100.v2._02_双指针;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&id=top-100-liked

public class _02_盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, w * h);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
