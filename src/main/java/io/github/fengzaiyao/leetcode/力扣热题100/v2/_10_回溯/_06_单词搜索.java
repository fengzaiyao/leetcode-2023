package io.github.fengzaiyao.leetcode.力扣热题100.v2._10_回溯;

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
                if (doExist(board, i, j, word, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean doExist(char[][] board, int x, int y, String word, int begin, boolean[][] visit) {
        if (begin == word.length()) {
            return true;
        }
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1 || visit[x][y] || board[x][y] != word.charAt(begin)) {
            return false;
        }
        visit[x][y] = true;
        boolean b1 = doExist(board, x - 1, y, word, begin + 1, visit);
        boolean b2 = doExist(board, x + 1, y, word, begin + 1, visit);
        boolean b3 = doExist(board, x, y - 1, word, begin + 1, visit);
        boolean b4 = doExist(board, x, y + 1, word, begin + 1, visit);
        visit[x][y] = false;
        return b1 || b2 || b3 || b4;
    }
}
