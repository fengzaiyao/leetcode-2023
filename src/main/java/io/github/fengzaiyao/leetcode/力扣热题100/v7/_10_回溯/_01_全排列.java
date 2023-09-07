package io.github.fengzaiyao.leetcode.力扣热题100.v7._10_回溯;

// https://leetcode.cn/problems/permutations/

import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _01_全排列 {

    public static void main(String[] args) {
        _01_全排列 test = new _01_全排列();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return new ArrayList<>();
        }
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

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
