package io.github.fengzaiyao.leetcode.力扣热题100.v8._10_回溯;

// https://leetcode.cn/problems/permutations/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void doPermute(List<List<Integer>> ans, int[] nums, int begin) {
        if (begin == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int num : nums) {
                item.add(num);
            }
            ans.add(item);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, begin, i);
            doPermute(ans, nums, begin + 1);
            swap(nums, i, begin);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
