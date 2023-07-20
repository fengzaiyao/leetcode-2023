package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/

public class 组合总和 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        doCombinationSum(candidates, result, new ArrayList<>(), target, 0);
        return result;
    }

    public static void doCombinationSum(int[] candidates, List<List<Integer>> result, List<Integer> path, int target, int begin) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            // 如果当前值大于要组成的值,直接跳过
            if (target < candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            doCombinationSum(candidates, result, path, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
