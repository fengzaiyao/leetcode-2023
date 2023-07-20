package io.github.fengzaiyao.leetcode.力扣热题100.v2._02_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/submissions/

public class _03_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 有重复跳过
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    retList.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r - 1 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return retList;
    }

}
