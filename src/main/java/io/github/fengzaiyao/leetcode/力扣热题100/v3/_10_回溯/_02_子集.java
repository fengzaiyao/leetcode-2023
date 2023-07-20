package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/?envType=study-plan-v2&id=top-100-liked

public class _02_子集 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        doSubsets(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void doSubsets(int[] nums, List<List<Integer>> ans, List<Integer> path, int start) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[start]);
        doSubsets(nums, ans, path, start + 1);
        path.remove(path.size() - 1);
        doSubsets(nums, ans, path, start + 1);
    }

}
