package io.github.fengzaiyao.leetcode.力扣热题100.v9._05_普通数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= r) {
                r = Math.max(r, intervals[i + 1][1]);
                i++;
            }
            ans.add(new int[]{l, r});
        }
        return ans.toArray(new int[0][]);
    }
}
