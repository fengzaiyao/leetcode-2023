package io.github.fengzaiyao.leetcode.力扣热题100.v4._06_矩阵;

import java.util.Arrays;

// https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&id=top-100-liked

public class _03_旋转图像 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 上线翻转
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                swap(matrix, i, j, row - i - 1, j);
            }
        }
        // "\" 对角线翻转
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
