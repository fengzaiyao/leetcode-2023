package io.github.fengzaiyao.leetcode.力扣热题100.v4._10_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/

public class _04_组合总和 {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        doCombinationSum(ans, new ArrayList<>(), target, candidates, 0);
        return ans;
    }

    private static void doCombinationSum(List<List<Integer>> ans, List<Integer> path, int target, int[] candidates, int begin) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            path.add(candidates[i]);
            doCombinationSum(ans, path, target - candidates[i], candidates, i);
            path.remove(path.size() - 1);
        }
    }
}
