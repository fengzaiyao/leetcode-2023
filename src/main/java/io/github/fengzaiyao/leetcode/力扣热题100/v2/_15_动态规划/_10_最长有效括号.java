package io.github.fengzaiyao.leetcode.力扣热题100.v2._15_动态规划;

import java.util.Stack;

// https://leetcode.cn/problems/longest-valid-parentheses/

public class _10_最长有效括号 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }

    public static int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    dp[i] = 1;
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            dp[stack.pop()] = 1;
        }
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == 0) {
                curLen++;
            } else {
                curLen = 0;
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
