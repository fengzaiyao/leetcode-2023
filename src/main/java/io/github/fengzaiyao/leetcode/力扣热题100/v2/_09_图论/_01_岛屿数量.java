package io.github.fengzaiyao.leetcode.力扣热题100.v2._09_图论;

// https://leetcode.cn/problems/number-of-islands/

public class _01_岛屿数量 {

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visitLands(grid, i, j);
                }
            }
        }
        return count;
    }

    private void visitLands(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        visitLands(grid, i - 1, j);
        visitLands(grid, i, j - 1);
        visitLands(grid, i + 1, j);
        visitLands(grid, i, j + 1);
    }
}
