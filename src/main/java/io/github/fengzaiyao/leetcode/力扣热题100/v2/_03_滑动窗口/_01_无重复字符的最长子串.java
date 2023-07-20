package io.github.fengzaiyao.leetcode.力扣热题100.v2._03_滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class _01_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch));
            }
            maxLen = Math.max(maxLen, i - left);
            map.put(ch, i);
        }
        return maxLen;
    }
}
