package io.github.fengzaiyao.leetcode.力扣热题100.v5._13_堆;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&id=top-100-liked

public class _03_数据流的中位数 {

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(1);
        test.addNum(2);
        // System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }

    static class MedianFinder {

        private PriorityQueue<Integer> l = new PriorityQueue<>((o1, o2) -> o2 - o1);
        private PriorityQueue<Integer> r = new PriorityQueue<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (l.size() == r.size()) {
                r.add(num);
                l.add(r.poll());
            } else {
                l.add(num);
                r.add(l.poll());
            }
        }

        public double findMedian() {
            if (((l.size() + r.size()) % 2) == 1) {
                return (double) (l.peek());
            } else {
                return ((double) l.peek() + r.peek()) / 2;
            }
        }
    }

}
