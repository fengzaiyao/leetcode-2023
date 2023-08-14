package io.github.fengzaiyao.leetcode.力扣热题100.v6._03_滑动窗口;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked

public class _01_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int l = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 注意这里用 Math.max(l, map.get(s.charAt(i))); 是因为怕出现 abba 这种情况
                l = Math.max(l, map.get(s.charAt(i)));
            }
            max = Math.max(max, i - l);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
