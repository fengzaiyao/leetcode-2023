package io.github.fengzaiyao.leetcode.力扣热题100.v5._06_矩阵;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/set-matrix-zeroes/

public class _01_矩阵置零 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer rowIdx : rows) {
            for (int i = 0; i < col; i++) {
                matrix[rowIdx][i] = 0;
            }
        }
        for (Integer colIdx : cols) {
            for (int i = 0; i < row; i++) {
                matrix[i][colIdx] = 0;
            }
        }
    }

}
