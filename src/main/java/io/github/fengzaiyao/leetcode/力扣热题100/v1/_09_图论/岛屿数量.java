package io.github.fengzaiyao.leetcode.力扣热题100.v1._09_图论;

// https://leetcode.cn/problems/number-of-islands/

public class 岛屿数量 {

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    visitIsLand(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void visitIsLand(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        visitIsLand(grid, i - 1, j);
        visitIsLand(grid, i + 1, j);
        visitIsLand(grid, i, j - 1);
        visitIsLand(grid, i, j + 1);
    }
}
