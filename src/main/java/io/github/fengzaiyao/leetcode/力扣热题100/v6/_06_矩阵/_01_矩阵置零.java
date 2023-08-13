package io.github.fengzaiyao.leetcode.力扣热题100.v6._06_矩阵;

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
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (Integer colIdx : colSet) {
                matrix[i][colIdx] = 0;
            }
        }
        for (int i = 0; i < col; i++) {
            for (Integer rowIdx : rowSet) {
                matrix[rowIdx][i] = 0;
            }
        }
    }

}
