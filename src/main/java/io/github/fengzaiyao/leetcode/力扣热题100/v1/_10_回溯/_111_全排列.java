package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/permutations/?envType=study-plan-v2&id=top-100-liked

public class _111_全排列 {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        doPermute(result, nums, 0);
        return result;
    }

    public static void doPermute(List<List<Integer>> result, int[] nums, int begin) {
        if (begin == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) {
                path.add(num);
            }
            result.add(path);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, begin, i);
            doPermute(result, nums, begin + 1);
            swap(nums, begin, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
