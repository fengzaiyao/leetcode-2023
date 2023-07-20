package io.github.fengzaiyao.leetcode.力扣热题100.v2._11_二分查找;

// https://leetcode.cn/problems/search-a-2d-matrix/submissions/

public class _02_搜索二维矩阵 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}},1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
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
