package io.github.fengzaiyao.leetcode.力扣热题100.v2._14_贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&id=top-100-liked

public class _04_划分字母区间 {

    public static void main(String[] args) {
        // "ababcbaca  defegde  hijhklij"
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ret = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        // 记录每个字符最后的位置
        for (int i = 0; i < chs.length; i++) {
            map.put(chs[i], i);
        }
        int begin = 0;
        while (begin < s.length()) {
            int end = map.get(s.charAt(begin));
            // 更新右边界
            for (int i = begin; i < end; i++) {
                end = Math.max(end, map.get(s.charAt(i)));
            }
            ret.add(end - begin + 1);
            // 下一次开始的位置
            begin = end + 1;
        }
        return ret;
    }
}
