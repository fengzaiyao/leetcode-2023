package io.github.fengzaiyao.leetcode.力扣热题100.v1._04_子串;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&id=top-100-liked

public class _111_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            needMap.put(ch, needMap.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        String ans = null;
        while (right < s.length()) {
            if (!cover(needMap, currMap)) {
                currMap.put(s.charAt(right), currMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }
            while (cover(needMap, currMap)) {
                String substring = s.substring(left, right);
                if (ans == null) {
                    ans = substring;
                } else if (ans.length() > substring.length()) {
                    ans = substring;
                }
                currMap.put(s.charAt(left), currMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }
        return ans == null ? "" : ans;
    }

    private static boolean cover(Map<Character, Integer> needMap, Map<Character, Integer> currMap) {
        for (Map.Entry<Character, Integer> entry : needMap.entrySet()) {
            if (!currMap.containsKey(entry.getKey()) || currMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
