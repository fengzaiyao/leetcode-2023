package io.github.fengzaiyao.leetcode.力扣热题100.v7._15_动态规划;

import java.util.Stack;

// https://leetcode.cn/problems/longest-valid-parentheses/

public class _10_最长有效括号 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(i);
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
        for (int i = 0; i < dp.length; i++) {
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
