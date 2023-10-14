package io.github.fengzaiyao.leetcode.力扣热题100.v9._10_回溯;

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

    public static void doSolveNQueens(List<List<String>> ans, int[] arr, int n, int begin) {
        if (begin == n) {
            List<String> strings = coverResult(arr);
            ans.add(strings);
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

    private static boolean check(int[] arr, int currIdx) {
        for (int i = 0; i < currIdx; i++) {
            if (arr[i] == arr[currIdx] || Math.abs(arr[currIdx] - arr[i]) == Math.abs(currIdx - i)) {
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
