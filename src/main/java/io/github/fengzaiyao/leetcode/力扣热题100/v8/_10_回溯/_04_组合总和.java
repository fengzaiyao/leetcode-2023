package io.github.fengzaiyao.leetcode.力扣热题100.v8._10_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/

public class _04_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        doCombinationSum(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    public void doCombinationSum(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int begin) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
        }
        if (begin > candidates.length) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            path.add(candidates[i]);
            doCombinationSum(ans, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
