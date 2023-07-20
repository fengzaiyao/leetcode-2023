package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/

public class _08_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        int[] path = new int[n];
        List<List<String>> ans = new ArrayList<>();
        doSolve(ans, n, path, 0);
        return ans;
    }

    public static void doSolve(List<List<String>> ans, int n, int[] path, int begin) {
        if (begin == n) {
            ans.add(coverResult(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            path[begin] = i;
            if (check(begin, path)) {
                doSolve(ans, n, path, begin + 1);
            }
        }
    }

    private static boolean check(int begin, int[] path) {
        for (int i = 0; i < begin; i++) {
            if (path[i] == path[begin] || Math.abs(begin - i) == Math.abs(path[begin] - path[i])) {
                return false;
            }
        }
        return true;
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
}
