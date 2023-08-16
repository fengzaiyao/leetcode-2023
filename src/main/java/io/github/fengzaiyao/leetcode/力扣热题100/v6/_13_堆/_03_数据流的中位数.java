package io.github.fengzaiyao.leetcode.力扣热题100.v6._13_堆;

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
        // 右边
        PriorityQueue<Integer> min = new PriorityQueue<>();
        // 左边
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (min.size() == max.size()) {
                min.add(num);
                max.add(min.poll());
            } else {
                max.add(num);
                min.add(max.poll());
            }
        }

        public double findMedian() {
            if ((min.size() + max.size()) % 2 != 0) {
                return (double) max.peek();
            } else {
                return ((double) max.peek() + min.peek()) / 2;
            }
        }
    }

}
