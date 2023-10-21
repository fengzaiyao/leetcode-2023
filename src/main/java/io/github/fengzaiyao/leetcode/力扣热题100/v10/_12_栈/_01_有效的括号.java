package io.github.fengzaiyao.leetcode.力扣热题100.v10._12_栈;

import java.util.Stack;

// https://leetcode.cn/problems/valid-parentheses/?envType=study-plan-v2&id=top-100-liked

public class _01_有效的括号 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                boolean b1 = (pop == '(' && ch != ')');
                boolean b2 = (pop == '[' && ch != ']');
                boolean b3 = (pop == '{' && ch != '}');
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
