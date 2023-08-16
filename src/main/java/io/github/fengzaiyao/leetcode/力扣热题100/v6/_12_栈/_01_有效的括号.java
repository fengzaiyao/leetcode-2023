package io.github.fengzaiyao.leetcode.力扣热题100.v6._12_栈;

import java.util.Stack;

// https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&id=top-100-liked

public class _01_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popCh = stack.pop();
                if (popCh == '(' && ch != ')') {
                    return false;
                }
                if (popCh == '{' && ch != '}') {
                    return false;
                }
                if (popCh == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
