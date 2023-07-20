package io.github.fengzaiyao.leetcode.力扣热题100.v5._02_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/submissions/

public class _03_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 先排序很关键
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + target == 0) {
                    ans.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    while (l + 1 < nums.length && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (r - 1 >= 0 && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + target > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

}
