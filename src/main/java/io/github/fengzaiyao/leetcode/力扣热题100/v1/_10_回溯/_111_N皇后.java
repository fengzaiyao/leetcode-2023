package io.github.fengzaiyao.leetcode.力扣热题100.v1._10_回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/n-queens/?envType=study-plan-v2&id=top-100-liked

public class _111_N皇后 {

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] arr = new int[n];
        doSolveNQueens(result, n, arr, 0);
        return result;
    }

    private static void doSolveNQueens(List<List<String>> result, int n, int[] arr, int curN) {
        if (curN == n) {
            List<String> strings = coverResult(arr);
            result.add(strings);
            return;
        }
        for (int i = 0; i < n; i++) {
            arr[curN] = i;
            if (!check(arr, curN)) {
                continue;
            }
            doSolveNQueens(result, n, arr, curN + 1);
        }
    }

    private static boolean check(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[n] == arr[i] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private static List<String> coverResult(int[] arr) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuffer buffer = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == j) {
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
