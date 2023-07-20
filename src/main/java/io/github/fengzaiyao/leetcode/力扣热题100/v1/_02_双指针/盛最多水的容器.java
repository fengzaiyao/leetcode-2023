package io.github.fengzaiyao.leetcode.力扣热题100.v1._02_双指针;

// https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&id=top-100-liked

public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int curHeight = Math.min(height[left], height[right]);
            int curArea = curHeight * (right - left);
            maxArea = Math.max(maxArea, curArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
