package io.github.fengzaiyao.leetcode.力扣热题100.v6._10_回溯;

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
        doSolveNQueens(arr, ans, n, 0);
        return ans;
    }

    public static void doSolveNQueens(int[] arr, List<List<String>> ans, int n, int curIdx) {
        if (curIdx == n) {
            ans.add(coverResult(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[curIdx] = i;
            if (!check(arr, n, curIdx)) {
                continue;
            }
            doSolveNQueens(arr, ans, n, curIdx + 1);
        }
    }

    private static boolean check(int[] arr, int n, int curIdx) {
        for (int i = 0; i < curIdx; i++) {
            if (arr[i] == arr[curIdx] || Math.abs(arr[i] - arr[curIdx]) == Math.abs(i - curIdx)) {
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
