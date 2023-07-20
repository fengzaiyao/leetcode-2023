package io.github.fengzaiyao.leetcode.力扣热题100.v1._06_矩阵;

// https://leetcode.cn/problems/search-a-2d-matrix-ii/

public class 搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col - 1;
        while (x < row && y >= 0) {
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
