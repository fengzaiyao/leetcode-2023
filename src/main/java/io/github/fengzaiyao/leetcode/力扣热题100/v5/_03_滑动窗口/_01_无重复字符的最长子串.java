package io.github.fengzaiyao.leetcode.力扣热题100.v5._03_滑动窗口;

import java.util.HashMap;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked

public class _01_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int l = -1;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                l = Math.max(l, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - l);
        }
        return maxLen;
    }
}
