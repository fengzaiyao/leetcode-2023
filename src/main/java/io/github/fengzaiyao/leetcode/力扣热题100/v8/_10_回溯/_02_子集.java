package io.github.fengzaiyao.leetcode.力扣热题100.v8._10_回溯;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/?envType=study-plan-v2&id=top-100-liked

public class _02_子集 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        doSubsets(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public static void doSubsets(List<List<Integer>> ans, List<Integer> path, int[] nums, int begin) {
        if (begin == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 保存这个元素
        path.add(nums[begin]);
        doSubsets(ans, path, nums, begin + 1);
        // 不保存这个元素
        path.remove(path.size() - 1);
        doSubsets(ans, path, nums, begin + 1);
    }
}
