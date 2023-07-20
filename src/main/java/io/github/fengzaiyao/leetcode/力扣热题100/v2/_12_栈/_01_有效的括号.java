package io.github.fengzaiyao.leetcode.力扣热题100.v2._12_栈;

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
                Character pushCh = stack.pop();
                if (pushCh == '(' && ch != ')') {
                    return false;
                }
                if (pushCh == '{' && ch != '}') {
                    return false;
                }
                if (pushCh == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
