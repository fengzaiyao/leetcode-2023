package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/

public class _08_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        doSolveNQueens(ans, new int[n], n, 0);
        return ans;
    }

    public static void doSolveNQueens(List<List<String>> ans, int[] path, int n, int begin) {
        if (begin == n) {
            ans.add(coverResult(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            path[begin] = i;
            if (check(path, begin)) {
                doSolveNQueens(ans, path, n, begin + 1);
            }
        }
    }

    public static boolean check(int[] path, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (path[n] == path[i] || (n - i) == Math.abs(path[n] - path[i])) {
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
