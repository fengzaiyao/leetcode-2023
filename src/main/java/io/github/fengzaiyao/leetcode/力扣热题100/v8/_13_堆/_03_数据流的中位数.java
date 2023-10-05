package io.github.fengzaiyao.leetcode.力扣热题100.v8._13_堆;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&id=top-100-liked

public class _03_数据流的中位数 {

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(1);
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }

    static class MedianFinder {

        private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);

        private PriorityQueue<Integer> right = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (left.size() == right.size()) {
                right.add(num);
                left.add(right.poll());
            } else {
                left.add(num);
                right.add(left.poll());
            }
        }

        public double findMedian() {
            if ((left.size() + right.size()) % 2 == 1) {
                return (double) left.peek();
            } else {
                return ((double) left.peek() + (double) right.peek()) / 2;
            }
        }
    }


}
