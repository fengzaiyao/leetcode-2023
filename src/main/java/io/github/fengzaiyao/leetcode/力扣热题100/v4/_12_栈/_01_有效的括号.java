package io.github.fengzaiyao.leetcode.力扣热题100.v4._12_栈;

import java.util.Stack;

// https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&id=top-100-liked

public class _01_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (ch == ')' && pop != '(') {
                    return false;
                }
                if (ch == '}' && pop != '{') {
                    return false;
                }
                if (ch == ']' && pop != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
