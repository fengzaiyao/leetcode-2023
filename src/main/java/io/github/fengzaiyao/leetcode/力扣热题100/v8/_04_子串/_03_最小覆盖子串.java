package io.github.fengzaiyao.leetcode.力扣热题100.v8._04_子串;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&id=top-100-liked

public class _03_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(minWindow("a", "a"));
//        System.out.println(minWindow("ab", "b"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> SMap = new HashMap<>();
        Map<Character, Integer> TMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            TMap.put(ch, TMap.getOrDefault(ch, 0) + 1);
        }
        String result = null;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            if (!isCover(SMap, TMap)) {
                char ch = s.charAt(r);
                SMap.put(ch, SMap.getOrDefault(ch, 0) + 1);
                r++;
            }
            while (isCover(SMap, TMap)) {
                if (result == null || r - l + 1 <= result.length()) {
                    result = s.substring(l, r);
                }
                char ch = s.charAt(l);
                SMap.put(ch, SMap.getOrDefault(ch, 0) - 1);
                l++;
            }
        }
        return result == null ? "" : result;
    }

    private static boolean isCover(Map<Character, Integer> SMap, Map<Character, Integer> TMap) {
        for (Map.Entry<Character, Integer> entry : TMap.entrySet()) {
            Integer value = SMap.get(entry.getKey());
            if (Objects.isNull(value) || value < TMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

}
