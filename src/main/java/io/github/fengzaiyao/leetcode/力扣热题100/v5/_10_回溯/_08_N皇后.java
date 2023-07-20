package io.github.fengzaiyao.leetcode.力扣热题100.v5._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/

public class _08_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        doSolveNQueens(n, 0, new int[n], ans);
        return ans;
    }

    private static void doSolveNQueens(int n, int cur, int[] arr, List<List<String>> ans) {
        if (cur == n) {
            ans.add(coverResult(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 第 cur 行摆第 i 列
            arr[cur] = i;
            if (!check(arr, cur)) {
                continue;
            }
            doSolveNQueens(n, cur + 1, arr, ans);
        }
    }

    private static boolean check(int[] arr, int cur) {
        for (int i = 0; i < cur; i++) {
            if (arr[i] == arr[cur] || Math.abs(cur - i) == Math.abs(arr[cur] - arr[i])) {
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
