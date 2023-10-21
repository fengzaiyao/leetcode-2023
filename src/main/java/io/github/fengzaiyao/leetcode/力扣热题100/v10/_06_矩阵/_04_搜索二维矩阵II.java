package io.github.fengzaiyao.leetcode.力扣热题100.v10._06_矩阵;

// https://leetcode.cn/problems/search-a-2d-matrix-ii/

public class _04_搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    y--;
                } else {
                    x++;
                }
            }
        }
        return false;
    }
}