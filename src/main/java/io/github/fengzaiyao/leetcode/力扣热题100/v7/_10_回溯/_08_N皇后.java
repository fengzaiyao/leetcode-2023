package io.github.fengzaiyao.leetcode.力扣热题100.v7._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/

public class _08_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] nums = new int[n];
        doSolveNQueens(ans, nums, n, 0);
        return ans;
    }

    public static void doSolveNQueens(List<List<String>> ans, int[] nums, int n, int current) {
        if (current == n) {
            ans.add(coverResult(nums));
            return;
        }
        for (int i = 0; i < n; i++) {
            nums[current] = i;
            if (!check(nums, current)) {
                continue;
            }
            doSolveNQueens(ans, nums, n, current + 1);
        }
    }

    private static List<String> coverResult(int[] arr) {
        List<String> result = new ArrayList<>();
        for (int value : arr) {
            StringBuilder buffer = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (value == j) {
                    buffer.append("Q");
                } else {
                    buffer.append(".");
                }
            }
            result.add(buffer.toString());
        }
        return result;
    }

    private static boolean check(int[] nums, int current) {
        for (int i = 0; i < current; i++) {
            boolean b1 = Math.abs(nums[i] - nums[current]) == Math.abs(i - current);
            boolean b2 = nums[i] == nums[current];
            if (b1 || b2) {
                return false;
            }
        }
        return true;
    }
}
