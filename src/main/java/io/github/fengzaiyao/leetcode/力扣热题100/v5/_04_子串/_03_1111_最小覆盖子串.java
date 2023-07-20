package io.github.fengzaiyao.leetcode.力扣热题100.v5._04_子串;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-window-substring/?envType=study-plan-v2&id=top-100-liked

public class _03_1111_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println("0123".substring(0,2));
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
        int l = 0;
        int r = 0;
        String ans = null;
        while (r < s.length()) {
            if (!contain(SMap, TMap)) {
                SMap.put(s.charAt(r), SMap.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
            while (contain(SMap, TMap)) {
                String substring = s.substring(l, r);
                if (ans == null || ans.length() > substring.length()) {
                    ans = substring;
                }
                SMap.put(s.charAt(l), SMap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return ans == null ? "" : ans;
    }

    public static boolean contain(Map<Character, Integer> SMap, Map<Character, Integer> TMap) {
        for (Map.Entry<Character, Integer> entry : TMap.entrySet()) {
            if (!SMap.containsKey(entry.getKey()) || SMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
