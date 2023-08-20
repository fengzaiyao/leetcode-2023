package io.github.fengzaiyao.leetcode.力扣热题100.v6._14_贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&id=top-100-liked

public class _04_111_划分字母区间 {

    public static void main(String[] args) {
        // "ababcbaca  defegde  hijhklij"
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int begin = 0;
        while (begin < chs.length) {
            Integer end = map.get(s.charAt(begin));
            // 拓展右边界
            for (int i = begin; i < end; i++) {
                end = Math.max(end, map.get(s.charAt(i)));
            }
            ans.add(end - begin + 1);
            begin = end + 1;
        }
        return ans;
    }
}
