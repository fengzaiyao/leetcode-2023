package io.github.fengzaiyao.leetcode.力扣热题100.v9._12_栈;

// https://leetcode.cn/problems/largest-rectangle-in-histogram/?envType=study-plan-v2&id=top-100-liked

import java.util.Stack;

public class _05_柱状图中最大的矩形 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        int len = heights.length + 2;
        int[] temp = new int[len];
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            temp[i + 1] = heights[i];
        }
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                int h = temp[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.add(i);
        }
        return maxArea;
    }
}
