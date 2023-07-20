package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/?envType=study-plan-v2&id=top-100-liked

public class 子集 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        doSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public static void doSubsets(List<List<Integer>> result, List<Integer> path, int[] nums, int begin) {
        if (begin == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 加上当前的
        path.add(nums[begin]);
        doSubsets(result, path, nums, begin + 1);
        // 不加当前的
        path.remove(path.size() - 1);
        doSubsets(result, path, nums, begin + 1);
    }
}
