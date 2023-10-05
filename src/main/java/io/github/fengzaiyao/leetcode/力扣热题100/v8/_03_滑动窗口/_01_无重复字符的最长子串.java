package io.github.fengzaiyao.leetcode.力扣热题100.v8._03_滑动窗口;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked

public class _01_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left);
        }
        return maxLen;
    }
}
