package io.github.fengzaiyao.leetcode.力扣热题100.v2._09_图论;//package io.github.fengzaiyao.leetcode.力扣热题100.v2._09_图论;
//
//import java.util.LinkedList;
//
//// https://leetcode.cn/problems/rotting-oranges/?envType=study-plan-v2&id=top-100-liked
//
//public class _02_腐烂的橘子 {
//
//
//    public static void main(String[] args) {
//        _02_腐烂的橘子 test = new _02_腐烂的橘子();
//        int count = test.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
//        System.out.println(count);
//    }
//
//
//    public int orangesRotting(int[][] grid) {
//        // 烂橘子坐标
//        LinkedList<int[]> queue = new LinkedList<>();
//        int row = grid.length;
//        int col = grid[0].length;
//        int maxLoop = 0;
//        // 计算最大循环轮次 and 第一轮烂橘子坐标
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 1) {
//                    maxLoop++;
//                }
//                if (grid[i][j] == 2) {
//                    queue.addLast(new int[]{i, j});
//                }
//            }
//        }
//        int round = 0;
//        while (maxLoop > 0 && !queue.isEmpty()) {
//            round++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int[] arr = queue.pollFirst();
//                int x = arr[0];
//                int y = arr[1];
//                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
//                    // 减少轮次/新鲜橘子数量
//                    maxLoop--;
//                    grid[x - 1][y] = 2;
//                    queue.addLast(new int[]{x - 1, y});
//                }
//                if (x + 1 <= row - 1 && grid[x + 1][y] == 1) {
//                    maxLoop--;
//                    grid[x + 1][y] = 2;
//                    queue.addLast(new int[]{x + 1, y});
//                }
//                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
//                    maxLoop--;
//                    grid[x][y - 1] = 2;
//                    queue.addLast(new int[]{x, y - 1});
//                }
//                if (y + 1 <= col - 1 && grid[x][y + 1] == 1) {
//                    maxLoop--;
//                    grid[x][y + 1] = 2;
//                    queue.addLast(new int[]{x, y + 1});
//                }
//            }
//        }
//        // 表示还有新鲜橘子,但是烂橘子 queue 以及没有了
//        if (maxLoop > 0) {
//            return -1;
//        }
//        return round;
//    }
//
//
////    class Orange {
////        public int x;
////        public int y;
////
////        public Orange(int x, int y) {
////            this.x = x;
////            this.y = y;
////        }
////    }
////
////    public int orangesRotting(int[][] grid) {
////        LinkedList<Orange> queue = new LinkedList<>();
////        int row = grid.length;
////        int col = grid[0].length;
////        int maxCnt = row * col;
////        for (int k = 0; k < maxCnt; k++) {
////            // 检验有没有全部腐败
////            if (isAllCorruption(grid)) {
////                return k;
////            }
////            // 每一轮腐败
////            for (int i = 0; i < row; i++) {
////                for (int j = 0; j < col; j++) {
////                    if (grid[i][j] == 2) {
////                        visit(grid, queue, i - 1, j);
////                        visit(grid, queue, i + 1, j);
////                        visit(grid, queue, i, j - 1);
////                        visit(grid, queue, i, j + 1);
////                    }
////                }
////            }
////            // 设置要腐败的橘子
////            while (!queue.isEmpty()) {
////                Orange o = queue.pollLast();
////                grid[o.x][o.y] = 2;
////            }
////        }
////        return -1;
////    }
////
////    private void visit(int[][] grid, LinkedList<Orange> queue, int i, int j) {
////        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0) {
////            return;
////        }
////        queue.addLast(new Orange(i, j));
////    }
////
////    private boolean isAllCorruption(int[][] grid) {
////        int row = grid.length;
////        int col = grid[0].length;
////        for (int i = 0; i < row; i++) {
////            for (int j = 0; j < col; j++) {
////                if (grid[i][j] == 1) {
////                    return false;
////                }
////            }
////        }
////        return true;
////    }
//}
//
//
