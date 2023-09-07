package io.github.fengzaiyao.leetcode.力扣热题100.v7._10_回溯;

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
                if (doExist(i, j, visit, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doExist(int i, int j, boolean[][] visit, char[][] board, String word, int begin) {
        if (begin == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visit[i][j] || board[i][j] != word.charAt(begin)) {
            return false;
        }
        visit[i][j] = true;
        boolean b1 = doExist(i - 1, j, visit, board, word, begin + 1);
        boolean b2 = doExist(i + 1, j, visit, board, word, begin + 1);
        boolean b3 = doExist(i, j - 1, visit, board, word, begin + 1);
        boolean b4 = doExist(i, j + 1, visit, board, word, begin + 1);
        visit[i][j] = false;
        return b1 || b2 || b3 || b4;
    }
}
