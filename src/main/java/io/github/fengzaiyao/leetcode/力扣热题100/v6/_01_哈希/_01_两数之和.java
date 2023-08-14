package io.github.fengzaiyao.leetcode.力扣热题100.v6._01_哈希;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/two-sum/submissions/

public class _01_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
