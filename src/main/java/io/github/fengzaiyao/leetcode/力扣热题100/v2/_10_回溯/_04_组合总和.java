package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/

public class _04_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先从小到大排序
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<>();
        doCombinationSum(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    public void doCombinationSum(List<List<Integer>> ret, List<Integer> path, int[] candidates, int target, int begin) {
        if (target == 0) {
            ret.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            // 不能变成负数,不能变得更小
            if (target - candidates[i] < 0) {
                continue;
            }
            path.add(candidates[i]);
            doCombinationSum(ret, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
