package io.github.fengzaiyao.leetcode.力扣热题100.v1._06_矩阵;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/set-matrix-zeroes/

public class 矩阵置零 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        // 计算要处理的行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // 处理行
        for (Integer r : rows) {
            for (int i = 0; i < col; i++) {
                matrix[r][i] = 0;
            }
        }
        // 处理列
        for (Integer c : cols) {
            for (int i = 0; i < row; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
