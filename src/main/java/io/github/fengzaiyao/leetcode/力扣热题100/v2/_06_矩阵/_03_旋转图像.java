package io.github.fengzaiyao.leetcode.力扣热题100.v2._06_矩阵;

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
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        // 上下翻转
        for (int i = 0; i <= row / 2; i++) {
            for (int j = 0; j <= col; j++) {
                swap(matrix, i, j, row - i, j);
            }
        }
        // 对角线翻转 "\"
        for (int i = 0; i <= row; i++) {
            for (int j = i; j <= col; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
