package io.github.fengzaiyao.leetcode.力扣热题100.v8._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/

public class _08_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] arr = new int[n];
        doSolveNQueens(ans, arr, n, 0);
        return ans;
    }

    private static void doSolveNQueens(List<List<String>> ans, int[] arr, int n, int begin) {
        if (begin == n) {
            // 添加结果
            ans.add(coverResult(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[begin] = i;
            if (!check(arr, begin)) {
                continue;
            }
            doSolveNQueens(ans, arr, n, begin + 1);
        }
    }

    private static boolean check(int[] arr, int begin) {
        for (int i = 0; i < begin; i++) {
            if (arr[i] == arr[begin] || Math.abs(i - begin) == Math.abs(arr[i] - arr[begin])) {
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
