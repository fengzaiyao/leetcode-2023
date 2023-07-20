package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

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
        doPermute(ans, nums, 0);
        return ans;
    }

    public void doPermute(List<List<Integer>> ans, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int num : nums) {
                item.add(num);
            }
            ans.add(item);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            doPermute(ans, nums, start + 1);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
