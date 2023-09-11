package io.github.fengzaiyao.leetcode.力扣热题100.v7._02_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/submissions/

public class _03_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 固定一个点,左右两边缩小
            int target = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int curNum = target + nums[l] + nums[r];
                if (curNum == 0) {
                    List<Integer> item = new ArrayList<>();
                    while (l + 1 < nums.length && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r - 1 >= 0 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    ans.add(Arrays.asList(target, nums[l], nums[r]));
                    l++;
                    r--;

                } else if (curNum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

}
