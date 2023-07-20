package io.github.fengzaiyao.leetcode.力扣热题100.v2._05_普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&id=top-100-liked

public class _02_合并区间 {

    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        // 排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        // 拓展边界
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            while (i + 1 < intervals.length && r >= intervals[i + 1][0]) {
                r = Math.max(r, intervals[i + 1][1]);
                i++;
            }
            ret.add(new int[]{l, r});
        }
        return ret.toArray(new int[0][]);
    }
}
