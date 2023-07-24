package io.github.fengzaiyao.leetcode.力扣热题100.v5._13_堆;

import java.util.*;

// https://leetcode.cn/problems/top-k-frequent-elements/

public class _02_前K个高频元素 {

    public static void main(String[] args) {
        int[] num = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(num));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 统计出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        // 组装结果
        int[] ans = new int[queue.size()];
        while (!queue.isEmpty()) {
            ans[queue.size() - 1] = queue.poll().getKey();
        }
        return ans;
    }
}
