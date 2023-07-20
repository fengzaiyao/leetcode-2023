package io.github.fengzaiyao.leetcode.力扣热题100.v1._12_栈;

import java.util.Stack;

// https://leetcode.cn/problems/min-stack/

public class 最小栈 {

    class MinStack {

        private Stack<Integer> com = new Stack<>();
        private Stack<Integer> min = new Stack<>();

        public MinStack() {
        }

        public void push(int val) {
            com.push(val);
            if (min.isEmpty()) {
                min.push(val);
            }else {
                int minVal = Math.min(min.peek(), val);
                min.push(minVal);
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
