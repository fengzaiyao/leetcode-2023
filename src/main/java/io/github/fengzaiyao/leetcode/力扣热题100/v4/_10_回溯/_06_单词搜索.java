package io.github.fengzaiyao.leetcode.力扣热题100.v4._10_回溯;

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
                if (doExist(word, 0, visit, board, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doExist(String word, int begin, boolean[][] visit, char[][] board, int i, int j) {
        if (begin == word.length()) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visit[i][j] || board[i][j] != word.charAt(begin)) {
            return false;
        }
        visit[i][j] = true;
        boolean b1 = doExist(word, begin + 1, visit, board, i + 1, j);
        boolean b2 = doExist(word, begin + 1, visit, board, i - 1, j);
        boolean b3 = doExist(word, begin + 1, visit, board, i, j + 1);
        boolean b4 = doExist(word, begin + 1, visit, board, i, j - 1);
        visit[i][j] = false;
        return b1 || b2 || b3 || b4;
    }
}
