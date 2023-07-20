package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

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
        doPath(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private static void doPath(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            path.add(candidates[i]);
            doPath(ans, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
