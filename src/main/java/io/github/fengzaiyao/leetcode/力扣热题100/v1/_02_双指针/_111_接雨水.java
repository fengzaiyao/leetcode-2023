package io.github.fengzaiyao.leetcode.力扣热题100.v1._02_双指针;

import java.util.Stack;

// https://leetcode.cn/problems/trapping-rain-water/

public class _111_接雨水 {

    public static int trap(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() &&  heights[stack.peek()] <= heights[i]) {
                Integer mid = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int height = Math.min(heights[stack.peek()], heights[i]) - heights[mid];
                int width = i - stack.peek() - 1;
                maxArea += (height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
