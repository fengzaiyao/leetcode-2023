package io.github.fengzaiyao.leetcode.力扣热题100.v7._12_栈;

import java.util.Stack;

// https://leetcode.cn/problems/min-stack/

public class _02_最小栈 {

    class MinStack {

        Stack<Integer> com = new Stack<>();
        Stack<Integer> min = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            com.add(val);
            if (min.isEmpty()) {
                min.add(val);
            } else {
                min.add(Math.min(min.peek(), val));
            }
        }

        public void pop() {
            com.pop();
            min.pop();
        }

        public int top() {
            return com.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
