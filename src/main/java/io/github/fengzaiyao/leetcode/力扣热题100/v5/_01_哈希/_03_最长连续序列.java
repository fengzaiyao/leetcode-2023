package io.github.fengzaiyao.leetcode.力扣热题100.v5._01_哈希;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/longest-consecutive-sequence/submissions/

public class _03_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            // 代表这个数字是当前连续的最小的
            if (!set.contains(num - 1)) {
                int count = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    count++;
                    curNum++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
