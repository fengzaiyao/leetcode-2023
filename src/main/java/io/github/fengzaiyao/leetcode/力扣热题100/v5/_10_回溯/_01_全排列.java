package io.github.fengzaiyao.leetcode.力扣热题100.v5._10_回溯;

// https://leetcode.cn/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class _01_全排列 {

    public static void main(String[] args) {
        _01_全排列 test = new _01_全排列();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        doPermute(ans, 0, nums);
        return ans;
    }

    public void doPermute(List<List<Integer>> ans, int begin, int[] nums) {
        if (begin == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) {
                path.add(num);
            }
            ans.add(path);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            doPermute(ans, begin + 1, nums);
            swap(nums, begin, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
