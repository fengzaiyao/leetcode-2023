package io.github.fengzaiyao.leetcode.力扣热题100.v4._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/

public class _08_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] path = new int[n];
        doSolve(ans, path, n, 0);
        return ans;
    }

    private static void doSolve(List<List<String>> ans, int[] path, int n, int curIndex) {
        if (curIndex == n) {
            ans.add(coverResult(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            path[curIndex] = i;
            if (check(curIndex, path)) {
                doSolve(ans, path, n, curIndex + 1);
            }
        }
    }

    private static boolean check(int curIndex, int[] path) {
        for (int i = 0; i < curIndex; i++) {
            if (path[curIndex] == path[i] || Math.abs(curIndex - i) == Math.abs(path[curIndex] - path[i])) {
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
