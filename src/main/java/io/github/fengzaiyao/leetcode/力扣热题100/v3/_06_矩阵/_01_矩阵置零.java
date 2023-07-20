package io.github.fengzaiyao.leetcode.力扣热题100.v3._06_矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> rowSet = new ArrayList<>();
        List<Integer> colSet = new ArrayList<>();
        // 找出行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        // 设置行
        for (Integer num : rowSet) {
            for (int j = 0; j < col; j++) {
                matrix[num][j] = 0;
            }
        }
        // 设置列
        for (Integer num : colSet) {
            for (int j = 0; j < row; j++) {
                matrix[j][num] = 0;
            }
        }
    }

}
