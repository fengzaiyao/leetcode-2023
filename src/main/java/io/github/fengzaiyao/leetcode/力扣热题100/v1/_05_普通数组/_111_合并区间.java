package io.github.fengzaiyao.leetcode.力扣热题100.v1._05_普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&id=top-100-liked

public class _111_合并区间 {

    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> retList = new ArrayList<>();
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        // 打印
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i + 1 < intervals.length && right >= intervals[i + 1][0]) {
                // 注意选一个大的
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            retList.add(new int[]{left, right});
        }
        return retList.toArray(new int[0][0]);
    }
}
