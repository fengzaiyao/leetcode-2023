package io.github.fengzaiyao.leetcode.力扣热题100.v9._10_回溯;

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
                if (doExist(board, word, visit, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doExist(char[][] board, String word, boolean[][] visit, int begin, int i, int j) {
        if (begin == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]) {
            return false;
        }
        if (word.charAt(begin) != board[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean b1 = doExist(board, word, visit, begin + 1, i + 1, j);
        boolean b2 = doExist(board, word, visit, begin + 1, i, j + 1);
        boolean b3 = doExist(board, word, visit, begin + 1, i - 1, j);
        boolean b4 = doExist(board, word, visit, begin + 1, i, j - 1);
        visit[i][j] = false;
        return b1 || b2 || b3 || b4;
    }
}
