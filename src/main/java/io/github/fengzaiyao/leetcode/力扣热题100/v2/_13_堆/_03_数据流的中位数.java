package io.github.fengzaiyao.leetcode.力扣热题100.v2._13_堆;

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

        PriorityQueue<Integer> min = new PriorityQueue<>();

        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (min.size() == max.size()) {
                max.add(num);
                min.add(max.poll());
            } else {
                min.add(num);
                max.add(min.poll());
            }
        }

        public double findMedian() {
            if ((min.size() + max.size()) % 2 == 1) {
                return ((double) min.peek());
            } else {
                return ((double)min.peek() + (double) max.peek()) / 2;
            }
        }
    }
}
