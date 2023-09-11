package io.github.fengzaiyao.leetcode.力扣热题100.v7._03_滑动窗口;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=study-plan-v2&envId=top-100-liked

public class _01_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int left = -1;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                // 注意这里用 Math.max(left , map.get(c)); 是因为怕出现 abba 这种情况
                left = Math.max(left, map.get(ch));
            }
            maxLen = Math.max(maxLen, i - left);
            map.put(ch, i);
        }
        return maxLen;
    }
}
