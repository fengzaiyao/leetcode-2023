package io.github.fengzaiyao.leetcode.力扣热题100.v4._12_栈;

// https://leetcode.cn/problems/largest-rectangle-in-histogram/?envType=study-plan-v2&id=top-100-liked

import java.util.Stack;

public class _05_柱状图中最大的矩形 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    public static int largestRectangleArea(int[] heights) {
        // 在左右两边添加0
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        int ans = 0;
        for (int i = 0; i < temp.length; i++) {
            // 单调递增
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) {
                Integer idx = stack.pop();
                int w = i - stack.peek() - 1;
                int h = temp[idx];
                ans = Math.max(ans, w * h);
            }
            stack.push(i);
        }
        return ans;
    }
}
