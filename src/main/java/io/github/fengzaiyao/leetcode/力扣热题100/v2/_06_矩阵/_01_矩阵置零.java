package io.github.fengzaiyao.leetcode.力扣热题100.v2._06_矩阵;

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
        // 处理行
        for (Integer rowNum : rowSet) {
            for (int i = 0; i < col; i++) {
                matrix[rowNum][i] = 0;
            }
        }
        // 处理列
        for (Integer colNum : colSet) {
            for (int i = 0; i < row; i++) {
                matrix[i][colNum] = 0;
            }
        }
    }
}
