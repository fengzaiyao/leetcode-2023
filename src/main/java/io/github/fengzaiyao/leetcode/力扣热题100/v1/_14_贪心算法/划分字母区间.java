package io.github.fengzaiyao.leetcode.力扣热题100.v1._14_贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&id=top-100-liked

public class 划分字母区间 {

    public static void main(String[] args) {
        // "ababcbaca  defegde  hijhklij"
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            map.put(chars[i], i);
        }
        int begin = 0;
        while (begin < len) {
            int end = map.get(chars[begin]);
            // 拓宽结束边界
            for (int i = begin; i < end; i++) {
                end = Math.max(end, map.get(chars[i]));
            }
            // System.out.println(s.substring(begin, end + 1));
            ans.add(end - begin + 1);
            begin = end + 1;
        }
        return ans;
    }
}
