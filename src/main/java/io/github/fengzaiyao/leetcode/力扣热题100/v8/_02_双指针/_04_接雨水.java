package io.github.fengzaiyao.leetcode.力扣热题100.v8._02_双指针;

import java.util.Stack;

// https://leetcode.cn/problems/trapping-rain-water/

public class _04_接雨水 {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] heights) {
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                Integer mid = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int h = Math.min(heights[stack.peek()], heights[i]) - heights[mid];
                int w = i - stack.peek() - 1;
                total += (h * w);
            }
            stack.add(i);
        }
        return total;
    }

}
