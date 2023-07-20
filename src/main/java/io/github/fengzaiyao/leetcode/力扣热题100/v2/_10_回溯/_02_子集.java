package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;


import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/subsets/?envType=study-plan-v2&id=top-100-liked

public class _02_子集 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        doSubsets(nums, 0, ret, new ArrayList<>());
        return ret;
    }

    public static void doSubsets(int[] nums, int begin, List<List<Integer>> ret, List<Integer> path) {
        if (begin == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        // 加上当前值
        path.add(nums[begin]);
        doSubsets(nums, begin + 1, ret, path);
        // 不加当前值
        path.remove(path.size() - 1);
        doSubsets(nums, begin + 1, ret, path);
    }

}
