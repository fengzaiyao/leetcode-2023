package io.github.fengzaiyao.leetcode.力扣热题100.v3._10_回溯;

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
                if (doSearch(board, word, visit, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean doSearch(char[][] board, String word, boolean[][] visit, int curIndex, int i, int j) {
        if (curIndex >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j] || word.charAt(curIndex) != board[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean b1 = doSearch(board, word, visit, curIndex + 1, i + 1, j);
        boolean b2 = doSearch(board, word, visit, curIndex + 1, i - 1, j);
        boolean b3 = doSearch(board, word, visit, curIndex + 1, i, j + 1);
        boolean b4 = doSearch(board, word, visit, curIndex + 1, i, j - 1);
        visit[i][j] = false;
        return b1 || b2 || b3 || b4;
    }
}
