package io.github.fengzaiyao.leetcode.力扣热题100.v6._13_堆;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&id=top-100-liked

public class _01_数组中的第K个最大元素 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
