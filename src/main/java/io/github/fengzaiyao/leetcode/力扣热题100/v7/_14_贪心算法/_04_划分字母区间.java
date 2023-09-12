package io.github.fengzaiyao.leetcode.力扣热题100.v7._14_贪心算法;

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
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), i);
        }
        int r = 0;
        while (r < s.length()) {
            Integer endIdx = map.get(s.charAt(r));
            for (int i = r; i < endIdx; i++) {
                endIdx = Math.max(endIdx, map.get(s.charAt(i)));
            }
            ans.add(endIdx - r + 1);
            r = endIdx + 1;
        }
        return ans;
    }
}
