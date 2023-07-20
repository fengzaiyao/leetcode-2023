package io.github.fengzaiyao.leetcode.力扣热题100.v1._01_哈希;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/longest-consecutive-sequence/submissions/

public class 最长连续序列 {

    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : nums) {
            // 如果有比当前还小的数字则跳过
            if (numSet.contains(num - 1)) {
                continue;
            }
            // 从小开始往上+1
            int count = 1;
            int tempNum = num + 1;
            while (numSet.contains(tempNum)) {
                count++;
                tempNum++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
