package io.github.fengzaiyao.leetcode.力扣热题100.v6._10_回溯;

// https://leetcode.cn/problems/word-search/?envType=study-plan-v2&id=top-100-liked

public class _06_单词搜索 {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'a'}}, "a"));
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (doExist(board, visit, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doExist(char[][] board, boolean[][] visit, String word, int begin, int x, int y) {
        if (begin == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visit[x][y] || word.charAt(begin) != board[x][y]) {
            return false;
        }
        visit[x][y] = true;
        boolean b1 = doExist(board, visit, word, begin + 1, x + 1, y);
        boolean b2 = doExist(board, visit, word, begin + 1, x - 1, y);
        boolean b3 = doExist(board, visit, word, begin + 1, x, y + 1);
        boolean b4 = doExist(board, visit, word, begin + 1, x, y - 1);
        visit[x][y] = false;
        return b1 || b2 || b3 || b4;
    }
}
