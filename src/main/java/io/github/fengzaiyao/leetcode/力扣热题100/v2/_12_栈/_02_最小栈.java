package io.github.fengzaiyao.leetcode.力扣热题100.v2._12_栈;

import java.util.Stack;

// https://leetcode.cn/problems/min-stack/

public class _02_最小栈 {

    class MinStack {

        Stack<Integer> min = new Stack<>();
        Stack<Integer> com = new Stack<>();

        public MinStack() {
        }

        public void push(int val) {
            com.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(Math.min(min.peek(), val));
            }
        }

        public void pop() {
            min.pop();
            com.pop();
        }

        public int top() {
            return com.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
