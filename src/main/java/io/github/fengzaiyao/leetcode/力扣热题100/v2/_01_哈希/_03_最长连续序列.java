package io.github.fengzaiyao.leetcode.力扣热题100.v2._01_哈希;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/longest-consecutive-sequence/submissions/

public class _03_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            // 如果没有包含比当前还小的数字,就认为是起点
            if (!set.contains(num - 1)) {
                int count = 1;
                int tempNum = num + 1;
                while (set.contains(tempNum)) {
                    tempNum++;
                    count++;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }
}
