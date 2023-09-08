package io.github.fengzaiyao.leetcode.力扣热题100.v6._01_哈希;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.cn/problems/longest-consecutive-sequence/submissions/

public class _03_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        int maxCnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 1;
            int number = num + 1;
            while (set.contains(number)) {
                number++;
                count++;
            }
            maxCnt = Math.max(maxCnt, count);
        }
        return maxCnt;
    }
}
