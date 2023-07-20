package io.github.fengzaiyao.leetcode.力扣热题100.v1._15_动态规划;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.cn/problems/longest-valid-parentheses/

public class _111_最长有效括号 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        // dp[i] = 0 正常的、dp[i] = 1 要剔除的
        int[] dp = new int[s.length()];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    dp[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        // 避免情况,例如: "(((("
        while (!stack.isEmpty()) {
            dp[stack.pop()] = 1;
        }
        System.out.println(Arrays.toString(dp));
        // 统计最长的有效括号
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                count = 0;
            } else {
                count++;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }
}
