package io.github.fengzaiyao.leetcode.力扣热题100.v1._13_堆;

import java.util.*;

// https://leetcode.cn/problems/top-k-frequent-elements/

public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] num = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(num));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[heap.size()];
        int idx = 0;
        while (!heap.isEmpty()) {
            result[idx++] = heap.poll().getKey();
        }
        return result;
    }
}
