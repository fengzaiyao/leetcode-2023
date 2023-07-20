package io.github.fengzaiyao.leetcode.力扣热题100.v4._04_子串;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&id=top-100-liked

public class _03_1111_最小覆盖子串 {

    public static void main(String[] args) {
        // System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("ab", "b"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        String ans = null;
        while (r < s.length()) {
            if (!isCover(smap, tmap)) {
                smap.put(s.charAt(r), smap.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
            while (isCover(smap, tmap)) {
                String substring = s.substring(l, r);
                if (ans == null || ans.length() > substring.length()) {
                    ans = substring;
                }
                smap.put(s.charAt(l), smap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return ans == null ? "" : ans;
    }

    public static boolean isCover(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (smap.get(entry.getKey()) == null || smap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
