package io.github.fengzaiyao.leetcode.力扣热题100.v7._13_堆;

import java.util.Comparator;
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

        // 左边大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 右边小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (maxHeap.size() == minHeap.size()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if ((maxHeap.size() + minHeap.size()) % 2 == 1) {
                return (double) maxHeap.peek();
            } else {
                return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
            }
        }
    }

}
