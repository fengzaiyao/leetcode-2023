package io.github.fengzaiyao.leetcode.力扣热题100.v5._12_栈;

// https://leetcode.cn/problems/daily-temperatures/?envType=study-plan-v2&id=top-100-liked

import java.util.Arrays;
import java.util.Stack;

public class _04_每日温度 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.peek();
                ans[idx] = i - idx;
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
