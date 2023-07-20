package io.github.fengzaiyao.leetcode.力扣热题100.v4._06_矩阵;

// https://leetcode.cn/problems/search-a-2d-matrix-ii/

public class _04_搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}