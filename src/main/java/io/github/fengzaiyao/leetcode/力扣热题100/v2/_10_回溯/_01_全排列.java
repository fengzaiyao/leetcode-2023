package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;

// https://leetcode.cn/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class _01_全排列 {

    public static void main(String[] args) {
        _01_全排列 test = new _01_全排列();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        doPermute(ret, nums, 0);
        return ret;
    }

    public void doPermute(List<List<Integer>> ret, int[] nums, int begin) {
        if (begin == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int num : nums) {
                item.add(num);
            }
            ret.add(item);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            doPermute(ret, nums, begin + 1);
            swap(nums, begin, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
