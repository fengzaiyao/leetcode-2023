package io.github.fengzaiyao.leetcode.力扣热题100.v5._06_矩阵;

// https://leetcode.cn/problems/search-a-2d-matrix-ii/

public class _04_搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}