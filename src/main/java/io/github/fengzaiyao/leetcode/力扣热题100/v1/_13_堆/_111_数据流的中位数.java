package io.github.fengzaiyao.leetcode.力扣热题100.v1._13_堆;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/find-median-from-data-stream/?envType=study-plan-v2&id=top-100-liked

public class _111_数据流的中位数 {

    public static void main(String[] args) {
        MedianFinder test = new MedianFinder();
        test.addNum(1);
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }

    static class MedianFinder {

        // [1,2,3,4,5,6] 大顶堆:[1,2,3] 小顶堆:[4,5,6]

        // 小顶堆
        private PriorityQueue<Integer> min = new PriorityQueue<>();
        // 大顶堆
        private PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (max.size() == min.size()) {
                min.add(num);
                max.add(min.poll());
            }else {
                max.add(num);
                min.add(max.poll());
            }
        }

        public double findMedian() {
            if (min.size() == max.size()) {
                return  ((((double) max.peek()) + ((double) min.peek())) / 2);
            }
            return max.peek();
        }
    }
}
