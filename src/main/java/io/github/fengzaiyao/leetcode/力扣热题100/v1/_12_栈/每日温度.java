package io.github.fengzaiyao.leetcode.力扣热题100.v1._12_栈;

// https://leetcode.cn/problems/daily-temperatures/?envType=study-plan-v2&id=top-100-liked

import java.util.Arrays;
import java.util.Stack;

public class 每日温度 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
